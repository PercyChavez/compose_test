package com.example.jetpackcomposeinstagram.model

import androidx.annotation.DrawableRes

/**
 * Created by PercyChávez on 21, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */
data class SuperHero(
    var superHeroName: String,
    var realName: String,
    var publisher: String,
    @DrawableRes var photo: Int
)
