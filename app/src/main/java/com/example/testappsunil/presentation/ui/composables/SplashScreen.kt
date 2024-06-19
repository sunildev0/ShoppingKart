package com.example.testappsunil.presentation.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.imageLoader
import coil.request.ImageRequest
import com.example.testappsunil.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashStarted: () -> Unit, onSplashFinished: () -> Unit) {

    DisposableEffect(Unit) {
        onSplashStarted()
        onDispose { }
    }

    LaunchedEffect(Unit) {
        delay(3000)
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(
                Color.White
            ),
        ) {
            SplashLoader()
        }
    }
}

@Composable
fun SplashLoader() {
    val gifDrawableResId = R.drawable.lengtu_shopping
    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(gifDrawableResId)
        .decoderFactory(GifDecoder.Factory())
        .crossfade(true)
        .build()

    val gifPainter = LocalContext.current.imageLoader.let {
        rememberAsyncImagePainter(
            model = imageRequest,
            imageLoader = it
        )
    }

    gifPainter.let {
        Image(
            painter = it,
            contentDescription = "Loading Icon",
            modifier = Modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth(0.3f)
        )
    }
    Text(
        text = "ShoppingKart",
        fontFamily = FontFamily.SansSerif,
        color = colorResource(id = R.color.teal_700),
        fontWeight = FontWeight.W900,
        fontSize = 24.sp
    )
}

@Preview
@Composable
fun PreviewSplashScreen() {
    SplashScreen(onSplashStarted = {}, onSplashFinished = {})
}