package com.example.jetpackcomposeinstagram.model

/**
 * Created by PercyChávez on 22, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */
sealed class Routes(val routes: String){
    object Pantalla1: Routes("pantalla1")
    object Pantalla2: Routes("pantalla2")
    object Pantalla3: Routes("pantalla3")
    object Pantalla4: Routes("pantalla4/{age}"){
        fun createRoute(age: Int) = "pantalla4/$age"
    }
    object Pantalla5: Routes("pantalla5?name={name}"){
        fun createRoute(name: String) = "pantalla5?name={$name}"
    }
}
