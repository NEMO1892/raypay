package com.org.sign_in.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.design_system.spacer.HorizontalSpacer
import com.org.design_system.spacer.VerticalSpacer
import com.org.design_system.theme.RaypayTheme
import com.org.features.auth.R

private val ErrorRed = Color(0xFFFF5A5A)
private val ErrorBackground = Color(0xff222020)

@Composable
internal fun ErrorPopUp(
    message: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(color = ErrorBackground, shape = RoundedCornerShape(15.dp))
            .padding(horizontal = 15.dp, vertical = 10.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_failed_login),
            contentDescription = null,
            tint = ErrorRed,
            modifier = Modifier.size(31.dp)
        )

        HorizontalSpacer(10.dp)

        Column {
            Text(
                text = "Failed",
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    letterSpacing = 0.sp,
                    color = ErrorRed
                )
            )

            VerticalSpacer(3.dp)

            Text(
                text = message,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp,
                    lineHeight = 16.sp,
                    letterSpacing = 0.sp,
                    color = ErrorRed
                )
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ErrorPopUpPreview() {
    RaypayTheme {
        ErrorPopUp(
            message = "Incorrect login or password. Try again",
            modifier = Modifier.padding(16.dp)
        )
    }
}
