package com.example.thirtydaysfood.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thirtydaysfood.R

// Set of Material typography styles to start with
val Sriracha = FontFamily(
    Font(R.font.sriracha)
)
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Sriracha,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = Sriracha,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontFamily = Sriracha,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    /*h4 = TextStyle(
        fontFamily = Sriracha,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp
    ),
    h5 = TextStyle(
        fontFamily = Sriracha,
        fontWeight = FontWeight.Bold,
        fontSize = 6.sp
    ),
    h6 = TextStyle(
        fontFamily = Sriracha,
        fontWeight = FontWeight.Bold,
        fontSize = 4.sp
    ),*/
    body1 = TextStyle(
        fontFamily = Sriracha,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)