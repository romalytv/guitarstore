package com.guitarstore.menu

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.view.MenuCompat
import com.guitarstore.menu.products.*
import com.guitarstore.menu.sort.SortHelper
import com.guitarstore.menu.sort.SortType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainActivity : ComponentActivity() {

    private val productsState: MutableStateFlow<Products> =
        MutableStateFlow(Products(ProductsWarehouse.productsList))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { InitUI() }

    }

    @Composable
    fun InitUI() {
        val products by productsState.collectAsState()
        ProductsGrid(products = products, this::startProductActivity)
    }

    private fun startProductActivity(productItem: ProductItem) {
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra(ProductActivity.KEY_TITLE, productItem.title)
        intent.putExtra(ProductActivity.KEY_PRICE, productItem.price)
        intent.putExtra(ProductActivity.KEY_IMAGE, productItem.image)
        intent.putExtra(ProductActivity.KEY_CATEGORY, productItem.category)
        startActivity(intent)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.products_menu, menu)
        MenuCompat.setGroupDividerEnabled(menu, true)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.groupId == R.id.sorting) {
            val type = when (item.itemId) {
                R.id.sort_a_z -> SortType.Alphabetically
                R.id.sort_price_asc -> SortType.PriceAsc
                R.id.sort_price_desc -> SortType.PriceDesc
                else -> SortType.Alphabetically
            }
            productsState.update {
                Products(
                    SortHelper().sortProducts(
                        type,
                        ProductsWarehouse.productsList
                    )
                )
            }
        } else if (item.groupId == R.id.filter) {
            val type = when (item.itemId) {
                R.id.filter_all -> FilterType.All
                R.id.filter_classic -> FilterType.Classic
                R.id.filter_electric -> FilterType.Electric
                R.id.filter_electroacoustic -> FilterType.ElectroAccoustic
                R.id.filter_bass -> FilterType.Bass
                R.id.filter_accessory -> FilterType.Accessories
                R.id.filter_cases -> FilterType.Cases
                else -> FilterType.All
            }
            productsState.update {
                Products(
                    FilterHelper().filterProducts(
                        type,
                        ProductsWarehouse.productsList
                    )
                )
            }
        }
        return true
    }
}