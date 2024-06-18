package com.example.testappsunil.presentation.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testappsunil.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Text(text = "Hello Sunil")
//            Fun1()
            BlogCategory()
        }
    }
}

//@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun Fun1(name: String = "Sunil") {
//    Text(
//        text = "Hello helo hello heloo fsh uirf fsdu sudfu dsfguhy reiuy hi hi hi hey hey$name",
//        fontStyle = FontStyle.Italic,
//        fontWeight = FontWeight.Bold,
//        color = Color.Blue,
//        fontSize = 36.sp,
//        textAlign = TextAlign.Center,
//        maxLines = 5
//    )

//    Image(
//        painter = painterResource(id = R.drawable.sample_image),
//        contentDescription = "dummy image",
//        contentScale = ContentScale.FillWidth
//    )

//    Button(onClick = { }, colors = ButtonDefaults.buttonColors(contentColor = Color.Green), enabled = true, elevation = ButtonDefaults.buttonElevation(12.dp)) {
//        Text(text = "Hello")
//        Image(
//            painter = painterResource(id = R.drawable.baseline_360_24),
//            contentDescription = "dummy image"
//        )
//    }
    val state = remember {
        mutableStateOf("")
    }
    TextField(
//        value = "Hi Sunil!", // value won't update
        value = state.value,
        onValueChange = {
            state.value = it
            Log.d("TAG", "Fun18675: $it")
        },
        label = { Text(text = "Enter username") },
        placeholder = { })

}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun BlogCategory() {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .padding(16.dp)
            .size(240.dp, 100.dp)
            .fillMaxWidth()
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "product image"
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "This is product title. This is product title. This is product title This is product titleThis is product title This is product title This is product title ",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    text = "This is product description. This is product description. This is product description. This is product description. This is product description.",
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

