package com.guitarstore.menu.products

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.guitarstore.menu.R

class ProductActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = intent.getStringExtra(KEY_TITLE)
        val price = intent.getDoubleExtra(KEY_PRICE,0.00)
        val category = intent.getStringExtra(KEY_CATEGORY)
        val img = intent.getIntExtra(KEY_IMAGE, R.drawable.guitar_electronic_cort_sfx)
        val productItem = ProductItem(title,price,category,img)

        setContent { ProductDetails(productItem) }
    }

    companion object {
        const val KEY_TITLE = "title"
        const val KEY_PRICE = "price"
        const val KEY_IMAGE = "image"
        const val KEY_CATEGORY = "category"
    }
}