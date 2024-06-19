package com.example.testappsunil.presentation.ui.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.imageLoader
import coil.request.ImageRequest
import com.example.testappsunil.R
import com.example.testappsunil.data.model.MyProductsResponse
import com.example.testappsunil.presentation.ui.activity.ui.theme.TestAppSunilTheme
import com.example.testappsunil.presentation.viewmodel.ProductsViewModel
import com.example.testappsunil.presentation.viewmodel.UiState

const val NAME = "name"
const val DESCRIPTION = "description"

@Composable
fun MainProducts(viewModel: ProductsViewModel = hiltViewModel(), onBackClick: () -> Unit) {

    val uiState by viewModel.getProductsResponse.collectAsState()

    Surface(color = MaterialTheme.colorScheme.background) {
        Box(modifier = Modifier.fillMaxSize()) {

            when (uiState) {
                is UiState.Loading -> {
                    LoadingIndicator()
                }

                is UiState.Success -> {
                    TestAppSunilTheme {
                        CustomTopAppBar((uiState as UiState.Success).data, onBackClick)
                    }
                }

                is UiState.Error -> {
                    Text(
                        text = "Error: ${(uiState as UiState.Error).message}",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(productsList: List<MyProductsResponse>, onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "ShoppingCart: Everything on sale!",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.white)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onBackClick }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700),
                    navigationIconContentColor = colorResource(id = R.color.white)
                )
            )
        }
    ) { paddingValues ->
        Log.d("TAG", "CustomTopAppBar: $paddingValues")
        DetailsContent(productsList)
    }
}

@Composable
fun LoadingIndicator() {
    val gifDrawableResId = R.drawable.home_loader
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

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        gifPainter.let {
            Image(
                painter = it,
                contentDescription = "Loading Icon",
                modifier = Modifier
                    .fillMaxHeight(0.2f)
                    .fillMaxWidth(0.2f)
            )
        }
    }
}

// Compose
@Composable
fun DetailsContent(employees: List<MyProductsResponse>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        LazyColumn(
        ) {
            items(
                items = employees,
                key = {
                    it.id!!
                },
            ) {
                ListItem(data = it)
            }
        }
    }

}

@Composable
fun ListItem(data: MyProductsResponse) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .padding(8.dp, 4.dp, 8.dp, 4.dp)
            .fillMaxWidth()
//                .height(200.dp)
            .wrapContentHeight(align = Alignment.CenterVertically)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            AsyncImage(
                model = data.image,
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "product image",
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .height(100.dp)
                    .padding(4.dp, 0.dp, 4.dp, 0.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = data.title.toString(),
                    maxLines = 1,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    text = data.description.toString(),
                    maxLines = 3,
                    color = Color.DarkGray,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun PreviewDesign() {
    val list = mutableListOf<MyProductsResponse>()
    list.add(
        MyProductsResponse(
            id = 1,
            title = "Mens Casual Premium Slim Fit T-Shirts ",
            price = 22.3,
            description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.",
            category = "men's clothing",
            image = "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",
            rating = MyProductsResponse.Rating(
                rate = 4.1,
                count = 259
            )
        )
    )

    list.add(
        MyProductsResponse(
            id = 3,
            title = "Mens Cotton Jacket",
            price = 55.99,
            description = "great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member. A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.",
            category = "men's clothing",
            image = "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg",
            rating = MyProductsResponse.Rating(
                rate = 2.5,
                count = 459
            )
        )
    )

    DetailsContent(list)
}
