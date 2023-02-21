package com.example.alejobootcampandroid.presentation.ui.theme

private val DarkColorPalette = darkColors(
    background = Color.Black,
    surface = Color.White,
    onSurface = GoldYellow,
    primary = GoldYellow,
    onPrimary = Color.Black,
    secondary = Color.Gray
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    background = Color.White,
    surface = Color.White,
    onSurface = Color.Black,
    primary = GoldYellow,
    onPrimary = Color.Black,
    secondary = Color.Gray,
    onSecondary = Color.Black
)

@Composable
fun AlejoBootcampAndroidAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}
