package makaota.app.cookingappui.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import makaota.app.cookingappui.R

val montserrat = FontFamily(
    listOf(
        Font(R.font.montserrat_regular, FontWeight.Normal),
        Font(R.font.montserrat_medium, FontWeight.Medium),
        Font(R.font.montserrat_black, FontWeight.Black),
        Font(R.font.montserrat_bold, FontWeight.Bold),
        Font(R.font.montserrat_extra_bold, FontWeight.ExtraBold),
        Font(R.font.montserrat_semi_bold, FontWeight.SemiBold),
        Font(R.font.montserrat_extra_light, FontWeight.ExtraLight),
        Font(R.font.montserrat_light, FontWeight.Light),
        Font(R.font.montserrat_thin, FontWeight.Thin),
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        color = Color.Black,
        fontFamily = montserrat,
        fontWeight = FontWeight.Thin,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        color = Color.Black,
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    ),
    h2 = TextStyle(
        color = Color.White,
        fontFamily = montserrat,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        color = Color.Gray,
        fontFamily = montserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp
    )
)