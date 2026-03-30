package com.org.sign_in.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.org.design_system.input_field.AuthInputFiled
import com.org.design_system.spacer.VerticalSpacer
import com.org.design_system.theme.RaypayTheme
import com.org.features.auth.R
import com.org.navigation.RayPayNavigator
import com.org.sign_in.ui.compose.SignInHeader
import com.org.sign_in.ui.mvi.SignInEffect
import com.org.sign_in.ui.mvi.SignInEvent
import com.org.sign_in.ui.mvi.SignInState
import com.org.sign_in.ui.mvi.SignInViewModel
import com.org.sign_in.ui.mvi.isErrorLogin
import com.org.sign_in.ui.mvi.isErrorPassword
import com.org.core.design_system.R as DesignSystemR
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

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
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    val eyeIcon =
        if (state.isPasswordVisible) DesignSystemR.drawable.ic_eye_on else DesignSystemR.drawable.ic_eye_off

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

            AuthInputFiled(
                title = "Login",
                placeHolderRes = "Enter your login",
                value = state.login,
                isFieldInError = state.isErrorLogin(),
                supportText = state.supportTextLogin,
                onValueChanged = { userEvent(SignInEvent.OnLoginValueChanged(it)) },
                focusManager = focusManager,
                focusRequester = focusRequester,
                modifier = Modifier.fillMaxWidth()
            )

            VerticalSpacer(15.dp)

            AuthInputFiled(
                title = "Password",
                placeHolderRes = "Enter your password",
                value = state.password,
                isFieldInError = state.isErrorPassword(),
                supportText = state.supportTextPassword,
                onValueChanged = { userEvent(SignInEvent.OnPasswordValueChanged(it)) },
                focusManager = focusManager,
                focusRequester = focusRequester,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                visualTransformation = if (state.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = eyeIcon),
                        contentDescription = null,
                        tint = Color(0xFFA2A2A2),
                        modifier = Modifier.clickable {
                            userEvent(SignInEvent.OnPasswordEyeIconClicked(state.isPasswordVisible))
                        },
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            VerticalSpacer(20.dp)

            Text(
                text = "Forgot password?",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    letterSpacing = 0.sp,
                    color = Color(0xFFBABABA)
                ),
                modifier = Modifier
                    .align(Alignment.Start)
                    .clickable { userEvent(SignInEvent.OnForgotPasswordClicked) }
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    userEvent(
                        SignInEvent.OnContinueClicked(
                            login = state.login,
                            password = state.password
                        )
                    )
                },
                enabled = state.isSignInButtonEnabled,
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.White,
                    disabledContainerColor = Color.White.copy(alpha = 0.4f),
                    disabledContentColor = Color.White.copy(alpha = 0.4f)
                ),
                contentPadding = PaddingValues(vertical = 22.dp, horizontal = 15.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Continue",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        lineHeight = 22.sp,
                        letterSpacing = 0.sp,
                        color = Color.Black
                    )
                )
            }
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