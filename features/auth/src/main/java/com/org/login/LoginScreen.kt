package com.org.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.org.design_system.theme.RaypayTheme
import com.org.features.auth.R
import com.org.login.compose.LoginFooter
import com.org.login.compose.RaypayLogo
import com.org.navigation.RayPayNavigator

@Composable
fun LoginScreen(
    rayPayNavigator: RayPayNavigator
) {
    LoginScreenContent(
        onLogInClicked = { rayPayNavigator.navigateToSignIn() },
        onSignUpClicked = { rayPayNavigator.navigateToSignUp() }
    )
}

@Composable
private fun LoginScreenContent(
    modifier: Modifier = Modifier,
    onLogInClicked: () -> Unit = {},
    onSignUpClicked: () -> Unit = {}
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_login_background),
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

            RaypayLogo()

            Spacer(modifier = Modifier.weight(1f))

            LoginFooter(
                onLogInClicked = onLogInClicked,
                onSignUpClicked = onSignUpClicked,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun LoginScreenContentPreview() {
    RaypayTheme {
        LoginScreenContent()
    }
}
