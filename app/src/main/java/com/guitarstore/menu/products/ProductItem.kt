package com.guitarstore.menu.products

import android.content.res.Resources.Theme
import androidx.annotation.DrawableRes
import org.w3c.dom.Comment

data class ProductItem(
    val title: String?,
    val price: Double?,
    val category: String?,
    @DrawableRes val image: Int?
)

data class Products(val items: List<ProductItem>)