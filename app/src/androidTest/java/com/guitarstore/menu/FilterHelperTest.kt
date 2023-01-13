package com.guitarstore.menu

import com.guitarstore.menu.products.ProductItem
import org.junit.Test

class FilterHelperTest() {



    private val sampleProductsList = mutableListOf(
        ProductItem(title = "Black tea", price = 3.00, category = "Drinks", R.drawable.black_tea),
        ProductItem(title = "Croissant", price = 7.00, category = "Dessert", R.drawable.croissant),
        ProductItem(title = "Bouillabaisse", price = 20.00, category = "Food", R.drawable.bouillabaisse)
    )
    @Test
    fun filterProducts_filterTypeDessert_croissantReturned() {
        FilterHelper().filterProducts(FilterType.Dessert,sampleProductsList)

    }
}