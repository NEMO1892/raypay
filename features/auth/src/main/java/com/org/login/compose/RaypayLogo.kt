package com.org.login.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
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
import com.org.design_system.spacer.VerticalSpacer
import com.org.design_system.theme.RaypayTheme
import com.org.core.design_system.R as DesignSystemR

@Composable
internal fun RaypayLogo(
    modifier: Modifier = Modifier
) {
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
                color = Color.White
            )
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0B1E30)
private fun RaypayLogoPreview() {
    RaypayTheme {
        RaypayLogo()
    }
}
