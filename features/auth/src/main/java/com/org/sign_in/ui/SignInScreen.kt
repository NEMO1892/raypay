package com.org.sign_in.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.org.design_system.loading.LoadingScreen
import com.org.design_system.spacer.VerticalSpacer
import com.org.design_system.theme.RaypayTheme
import com.org.features.auth.R
import com.org.navigation.RayPayNavigator
import com.org.sign_in.ui.compose.ErrorPopUp
import com.org.sign_in.ui.compose.SignInContinueButton
import com.org.sign_in.ui.compose.SignInHeader
import com.org.sign_in.ui.compose.SignInInputFields
import com.org.sign_in.ui.mvi.SignInEffect
import com.org.sign_in.ui.mvi.SignInEvent
import com.org.sign_in.ui.mvi.SignInState
import com.org.sign_in.ui.mvi.SignInViewModel
import com.org.sign_in.ui.mvi.isShowSignInError
import kotlinx.coroutines.delay

private const val ERROR_POP_UP_DELAY = 3_000L

@Composable
fun SignInScreen(
    rayPayNavigator: RayPayNavigator,
    viewModel: SignInViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                SignInEffect.NavigateBack -> rayPayNavigator.navigateBack()
                SignInEffect.NavigateToForgotPassword -> rayPayNavigator.navigateToForgotPassword()
            }
        }
    }

    SignInScreenContent(
        state = state,
        userEvent = viewModel::handleEvent
    )
}

@Composable
private fun SignInScreenContent(
    state: SignInState,
    userEvent: (SignInEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    if (state.isLoading) {
        LoadingScreen(modifier = Modifier.fillMaxSize())
        return
    }

    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_login_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .padding(start = 38.dp, end = 38.dp, top = 60.dp, bottom = 100.dp)
        ) {
            SignInHeader()

            VerticalSpacer(60.dp)

            SignInInputFields(
                state = state,
                userEvent = userEvent,
                focusManager = focusManager,
                focusRequester = focusRequester
            )

            Spacer(modifier = Modifier.weight(1f))

            SignInContinueButton(
                state = state,
                userEvent = userEvent
            )
        }

        if (state.isShowSignInError()) {
            LaunchedEffect(state.signInPopupErrorText) {
                delay(ERROR_POP_UP_DELAY)
                userEvent(SignInEvent.OnDismissSignInError)
            }

            ErrorPopUp(
                message = state.signInPopupErrorText ?: "Unknown Error, please try later.",
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
                    .systemBarsPadding()
                    .padding(top = 30.dp, start = 24.dp, end = 24.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun SignInScreenContentPreview() {
    RaypayTheme {
        SignInScreenContent(
            state = SignInState(),
            userEvent = {}
        )
    }
}