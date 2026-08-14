package com.ultratools.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val UltraTypography = Typography(

    displayLarge = androidx.compose.ui.text.TextStyle(
        fontSize = 38.sp,
        lineHeight = 44.sp,
        fontWeight = FontWeight.Bold
    ),

    headlineLarge = androidx.compose.ui.text.TextStyle(
        fontSize = 30.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight.Bold
    ),

    headlineMedium = androidx.compose.ui.text.TextStyle(
        fontSize = 24.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.SemiBold
    ),

    titleLarge = androidx.compose.ui.text.TextStyle(
        fontSize = 20.sp,
        lineHeight = 26.sp,
        fontWeight = FontWeight.SemiBold
    ),

    bodyLarge = androidx.compose.ui.text.TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),

    bodyMedium = androidx.compose.ui.text.TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),

    labelLarge = androidx.compose.ui.text.TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.SemiBold
    )
)
