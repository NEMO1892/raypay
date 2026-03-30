package com.org.sign_in.ui.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(

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
        // TODO: add validation logic and sending request
    }

    private fun handleOnForgotPasswordClicked() {
        _effects.trySend(SignInEffect.NavigateToForgotPassword)
    }
}
