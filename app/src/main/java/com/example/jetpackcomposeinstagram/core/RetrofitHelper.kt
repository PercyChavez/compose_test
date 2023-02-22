package com.example.jetpackcomposeinstagram.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by PercyChávez on 06, August, 2021.
 * Copyright (c) 2021 Llamafood. All rights reserved.
 */

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create()) //* convierte la respuesta en clase
                .build()
    }

}