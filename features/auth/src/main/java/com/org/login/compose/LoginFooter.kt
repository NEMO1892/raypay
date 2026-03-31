package com.org.login.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.org.design_system.spacer.VerticalSpacer
import com.org.design_system.theme.PoppinsFontFamily
import com.org.design_system.theme.RaypayTheme

@Composable
internal fun LoginFooter(
    onLogInClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to \"Raypay\"\nfinance mobile app",
            textAlign = TextAlign.Start,
            style = TextStyle(
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 25.sp,
                lineHeight = 32.sp,
                letterSpacing = 0.em,
                color = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )

        VerticalSpacer(40.dp)

        Button(
            onClick = onLogInClicked,
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White.copy(alpha = 0.2f),
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(vertical = 22.dp, horizontal = 15.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Log in",
                style = TextStyle(
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    letterSpacing = 0.em,
                    color = Color.White
                )
            )
        }

        VerticalSpacer(20.dp)

        Text(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFBABABA)
                    )
                ) {
                    append("Don't have an account? ")
                }
                withStyle(
                    SpanStyle(
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFFFFFFF)
                    )
                ) {
                    append("Sign Up")
                }
            },
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.em
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onSignUpClicked() }
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0B1E30)
private fun LoginFooterPreview() {
    RaypayTheme {
        LoginFooter(
            onLogInClicked = {},
            onSignUpClicked = {}
        )
    }
}
