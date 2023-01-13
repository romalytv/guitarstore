package com.guitarstore.menu

import com.guitarstore.menu.products.ProductItem

class FilterHelper {

    fun filterProducts(type: FilterType, productsList: List<ProductItem>): List<ProductItem> {
        return when (type) {
            FilterType.All -> productsList

            FilterType.Classic ->
                productsList.filterClassic()

            FilterType.Electric ->
                productsList.filterElectric()

            FilterType.ElectroAccoustic ->
                productsList.filterElectroAccoustic()

            FilterType.Bass ->
                productsList.filterBass()

            FilterType.Accessories ->
                productsList.filterAccesories()

            FilterType.Cases ->
                productsList.filterCases()

        }
    }

    private fun List<ProductItem>.filterClassic(): List<ProductItem> {
        return  filter {
            it.category == "Classic"
        }
    }

    private fun List<ProductItem>.filterElectric(): List<ProductItem> {
        return  filter {
            it.category == "Electric"
        }
    }

    private fun List<ProductItem>.filterElectroAccoustic(): List<ProductItem> {
        return  filter {
            it.category == "Electro-Accoustic"
        }
    }

    private fun List<ProductItem>.filterBass(): List<ProductItem> {
        return  filter {
            it.category == "Bass"
        }
    }

    private fun List<ProductItem>.filterAccesories(): List<ProductItem> {
        return  filter {
            it.category == "Accessory"
        }
    }

    private fun List<ProductItem>.filterCases(): List<ProductItem> {
        return  filter {
            it.category == "Cases"
        }
    }

}