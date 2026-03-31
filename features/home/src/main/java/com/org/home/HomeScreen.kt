package com.org.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.core.design_system.R as DesignSystemR
import com.org.design_system.spacer.VerticalSpacer
import com.org.design_system.theme.RaypayTheme
import com.org.design_system.theme.titleGradientBrush
import com.org.navigation.RayPayNavigator

@Composable
fun HomeScreen(
    rayPayNavigator: RayPayNavigator
) {
    HomeScreenContent()
}

@Composable
private fun HomeScreenContent(
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
                    text = "Home screen after successful sign in",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 33.sp,
                        brush = titleGradientBrush
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun HomeScreenContentPreview() {
    RaypayTheme {
        HomeScreenContent()
    }
}
