package com.org.design_system.loading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

val titleGradient = Brush.linearGradient(
    colorStops = arrayOf(
        0.0f  to Color.White,
        0.48f to Color(0x7A419AA0)
    )
)

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = DesignSystemR.drawable.ic_loading_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 25.dp, vertical = 80.dp),
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = DesignSystemR.drawable.ic_app_icon),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(width = 109.dp, height = 92.dp)
                )

                VerticalSpacer(32.dp)

                Text(
                    text = "raypay",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 33.sp,
                        brush = titleGradient
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

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
}

@Composable
@Preview(showBackground = true)
private fun LoadingScreenPreview() {
    RaypayTheme {
        LoadingScreen()
    }
}
