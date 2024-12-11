package com.example.lazyverticalgridimagenes

import androidx.annotation.DrawableRes

data class Model(
    var titulo: String,
    @DrawableRes var imagen: Int,
)