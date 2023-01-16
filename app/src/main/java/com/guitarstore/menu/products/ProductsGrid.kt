package com.guitarstore.menu.products

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.guitarstore.menu.ui.theme.Purple600
import com.guitarstore.menu.ui.theme.fontFamily

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductsGrid(products: Products, startProductActivity: (ProductItem) -> Unit) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(count = 3),
        contentPadding = PaddingValues(30.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            items = products.items,
            itemContent = { productItem: ProductItem ->
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = productItem.image!!),
                        contentDescription = productItem.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clickable {
                           startProductActivity.invoke(productItem)
                        }
                    )
                    Text(text = productItem.title!!,
                        color = Purple600,
                        fontSize = 14.sp,
                        fontFamily = fontFamily,
                        textAlign = TextAlign.Center
                    )
                }
            }
        )
    }
}