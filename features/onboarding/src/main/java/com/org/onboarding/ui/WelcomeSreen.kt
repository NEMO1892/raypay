package com.org.onboarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.org.design_system.theme.RaypayTheme
import com.org.features.onboarding.R
import com.org.navigation.RayPayNavigator
import com.org.onboarding.compose.WelcomeFooter
import com.org.onboarding.compose.WelcomeHeader


@Composable
fun WelcomeScreen(
    rayPayNavigator: RayPayNavigator
) {
    WelcomeScreenContent(
        onGetStartedClick = {
            rayPayNavigator.navigateToLogIn()
        }
    )
}

@Composable
private fun WelcomeScreenContent(
    modifier: Modifier = Modifier,
    onGetStartedClick: () -> Unit = {}
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_welcome_bacground),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 25.dp, vertical = 80.dp),
        ) {
            WelcomeHeader()

            Spacer(modifier = Modifier.weight(1f))

            WelcomeFooter(
                onGetStartedClicked = onGetStartedClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun WelcomeScreenContentPreview() {
    RaypayTheme {
        WelcomeScreenContent()
    }
}