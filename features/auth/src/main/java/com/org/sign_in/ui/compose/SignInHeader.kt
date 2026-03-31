package com.org.sign_in.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.design_system.spacer.HorizontalSpacer
import com.org.design_system.spacer.VerticalSpacer
import com.org.design_system.theme.PoppinsFontFamily
import com.org.design_system.theme.RaypayTheme
import com.org.core.design_system.R as DesignSystemR

@Composable
internal fun SignInHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = DesignSystemR.drawable.ic_app_icon),
                contentDescription = null,
                tint = Color.White
            )

            HorizontalSpacer(6.dp)

            Text(
                text = "raypay",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 35.sp,
                    lineHeight = 46.sp,
                    letterSpacing = 0.sp,
                    color = Color.White
                )
            )
        }

        VerticalSpacer(120.dp)

        Text(
            text = "Welcome back",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 40.sp,
                lineHeight = 46.sp,
                letterSpacing = 0.sp,
                color = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )

        VerticalSpacer(10.dp)

        Text(
            text = "Sign up to your account",
            style = TextStyle(
                fontFamily = PoppinsFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0B1E30)
private fun SignInHeaderPreview() {
    RaypayTheme {
        SignInHeader()
    }
}
