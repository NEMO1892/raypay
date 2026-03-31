package com.org.sign_in.ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import com.org.design_system.input_field.AuthInputFiled
import com.org.design_system.spacer.VerticalSpacer
import com.org.design_system.theme.PoppinsFontFamily
import com.org.sign_in.ui.mvi.SignInEvent
import com.org.sign_in.ui.mvi.SignInState
import com.org.sign_in.ui.mvi.isErrorLogin
import com.org.sign_in.ui.mvi.isErrorPassword
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import com.org.core.design_system.R as DesignSystemR

@Composable
internal fun SignInInputFields(
    state: SignInState,
    userEvent: (SignInEvent) -> Unit,
    focusManager: FocusManager,
    focusRequester: FocusRequester,
    modifier: Modifier = Modifier
) {
    val eyeIcon =
        if (state.isPasswordVisible) DesignSystemR.drawable.ic_eye_on else DesignSystemR.drawable.ic_eye_off

    Column(modifier = modifier) {
        AuthInputFiled(
            placeHolderRes = "Enter your login",
            value = state.login,
            isFieldInError = state.isErrorLogin(),
            supportText = state.supportTextLogin,
            onValueChanged = { userEvent(SignInEvent.OnLoginValueChanged(it)) },
            focusManager = focusManager,
            focusRequester = focusRequester,
            modifier = Modifier.fillMaxWidth()
        )

        VerticalSpacer(8.dp)

        AuthInputFiled(
            placeHolderRes = "Enter your password",
            value = state.password,
            isFieldInError = state.isErrorPassword(),
            supportText = state.supportTextPassword,
            onValueChanged = { userEvent(SignInEvent.OnPasswordValueChanged(it)) },
            focusManager = focusManager,
            focusRequester = focusRequester,
            keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(imeAction = ImeAction.Done),
            visualTransformation = if (state.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = eyeIcon),
                    contentDescription = null,
                    tint = Color(0xFFA2A2A2),
                    modifier = Modifier.clickable {
                        userEvent(SignInEvent.OnPasswordEyeIconClicked(state.isPasswordVisible))
                    }
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Forgot password?",
            style = TextStyle(
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.sp,
                color = Color(0xFFBABABA)
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .clickable { userEvent(SignInEvent.OnForgotPasswordClicked) }
        )
    }
}
