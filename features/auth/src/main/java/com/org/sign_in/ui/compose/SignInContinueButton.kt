package com.org.sign_in.ui.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.design_system.theme.PoppinsFontFamily
import com.org.sign_in.ui.mvi.SignInEvent
import com.org.sign_in.ui.mvi.SignInState

@Composable
internal fun SignInContinueButton(
    state: SignInState,
    userEvent: (SignInEvent) -> Unit,
    modifier: Modifier = Modifier
) {
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
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Continue",
            style = TextStyle(
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 22.sp,
                letterSpacing = 0.sp,
                color = Color.Black
            )
        )
    }
}
