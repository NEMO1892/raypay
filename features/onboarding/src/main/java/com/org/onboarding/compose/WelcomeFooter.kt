package com.org.onboarding.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.org.design_system.spacer.VerticalSpacer
import com.org.design_system.theme.RaypayTheme
import com.org.core.design_system.R as DesignSystemR

val h5GradientBrush = Brush.linearGradient(
    colorStops = arrayOf(
        0.0137f to Color.White.copy(alpha = 0.4f),
        0.5027f to Color.White.copy(alpha = 0.8f),
        1.00f to Color.White.copy(alpha = 0.4f)
    ),
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)

@Composable
internal fun WelcomeFooter(
    onGetStartedClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Your\nFinancial\nUnder\nControl",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 56.sp,
                lineHeight = 75.sp,
                letterSpacing = (-0.02).em,
                color = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        )
        VerticalSpacer(40.dp)

        Button(
            onClick = onGetStartedClicked,
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White.copy(alpha = 0.2f),
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(vertical = 22.dp, horizontal = 15.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Get started",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    letterSpacing = 0.sp,
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(id = DesignSystemR.drawable.ic_arrow_right),
                contentDescription = null,
            )
        }

        VerticalSpacer(20.dp)

        Text(
            text = "Welcome to RayPay Mobile App",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.sp,
                brush = h5GradientBrush
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun WelcomeFooterPreview() {
    RaypayTheme {
        WelcomeFooter(
            onGetStartedClicked = {}
        )
    }
}