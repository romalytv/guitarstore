package com.guitarstore.menu

sealed class FilterType {
    object All : FilterType()
    object Classic : FilterType()
    object Electric : FilterType()
    object ElectroAccoustic : FilterType()
    object Bass : FilterType()
    object Accessories : FilterType()
    object Cases : FilterType()
}
