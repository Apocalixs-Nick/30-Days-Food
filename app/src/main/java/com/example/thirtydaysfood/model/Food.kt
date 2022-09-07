package com.example.thirtydaysfood.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Food(@StringRes val dayFood: Int, @StringRes val titleFood: Int,@DrawableRes val imageFood: Int, @StringRes val descriptionFood: Int)
