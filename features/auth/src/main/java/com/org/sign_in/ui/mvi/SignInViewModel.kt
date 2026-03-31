package com.org.sign_in.ui.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.auth.model.DomainAuthError
import com.org.auth.use_case.SignInUseCase
import com.org.common.validation.AuthValidator
import com.org.common.validation.ValidationResult
import com.org.common.validation.emailMessage
import com.org.common.validation.passwordMessage
import com.org.sign_in.utils.updateForAuthError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authValidator: AuthValidator,
    private val signInUseCase: SignInUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(SignInState())
    val state: StateFlow<SignInState> = _state.asStateFlow()

    private val _effects = Channel<SignInEffect>(capacity = Channel.CONFLATED)
    val effect = _effects.receiveAsFlow()

    internal fun handleEvent(event: SignInEvent) {
        when (event) {
            SignInEvent.OnBackClicked -> handleOnBackClicked()
            is SignInEvent.OnLoginValueChanged -> handleOnLoginValueChanged(event.value)
            is SignInEvent.OnPasswordValueChanged -> handleOnPasswordValueChanged(event.value)
            is SignInEvent.OnPasswordEyeIconClicked -> handleOnPasswordEyeIconClicked(event.isPasswordVisible)
            is SignInEvent.OnContinueClicked -> handleOnContinueClicked(event.login, event.password)
            is SignInEvent.OnForgotPasswordClicked -> handleOnForgotPasswordClicked()
            is SignInEvent.OnDismissSignInError -> _state.update { it.copy(signInPopupErrorText = null) }
        }
    }

    private fun handleOnLoginValueChanged(login: String) {
        _state.update {
            it.copy(
                login = login,
                supportTextLogin = null,
                isSignInButtonEnabled = true
            )
        }
    }

    private fun handleOnPasswordValueChanged(password: String) {
        _state.update {
            it.copy(
                password = password,
                supportTextPassword = null,
                isSignInButtonEnabled = true
            )
        }
    }

    private fun handleOnPasswordEyeIconClicked(isPasswordVisible: Boolean) {
        _state.update {
            it.copy(
                isPasswordVisible = isPasswordVisible.not()
            )
        }
    }

    private fun handleOnBackClicked() {
        _effects.trySend(SignInEffect.NavigateBack)
    }

    private fun handleOnContinueClicked(login: String, password: String) {
        when (val validationResult = authValidator.validateEmailAndPassword(login, password)) {
            ValidationResult.Success -> {
                viewModelScope.launch {
                    _state.update {
                        it.copy(isLoading = true, isSignInButtonEnabled = false)
                    }
                    signInUseCase(login, password)
                        .onSuccess {
                            _state.update {
                                it.copy(
                                    isSignInButtonEnabled = true,
                                    supportTextLogin = null,
                                    supportTextPassword = null,
                                    isLoading = false
                                )
                            }

                            _effects.trySend(SignInEffect.NavigateToHome)
                        }
                        .onFailure { throwable ->
                            val authError = throwable as? DomainAuthError
                            _state.update {
                                it.updateForAuthError(authError)
                            }
                        }
                }
            }

            is ValidationResult.Error -> {
                _state.update { signInState ->
                    signInState.copy(
                        isLoading = false,
                        supportTextLogin = validationResult.errors.emailMessage(),
                        supportTextPassword = validationResult.errors.passwordMessage(),
                        isSignInButtonEnabled = signInState.isErrorLogin() || signInState.isErrorPassword()
                    )
                }
            }
        }
    }

    private fun handleOnForgotPasswordClicked() {
        _effects.trySend(SignInEffect.NavigateToForgotPassword)
    }
}
