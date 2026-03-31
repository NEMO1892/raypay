package com.org.design_system.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val titleGradientBrush = Brush.linearGradient(
    colorStops = arrayOf(
        0.0f to Color.White,
        1.0f to Color(0xFF419AA0).copy(alpha = 0.30f)
    )
)

val h5GradientBrush = Brush.linearGradient(
    colorStops = arrayOf(
        0.0137f to Color.White.copy(alpha = 0.4f),
        0.5027f to Color.White.copy(alpha = 0.8f),
        1.00f  to Color.White.copy(alpha = 0.4f)
    ),
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)
