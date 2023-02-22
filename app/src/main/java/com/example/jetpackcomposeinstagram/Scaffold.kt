package com.example.jetpackcomposeinstagram

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * Created by PercyChávez on 21, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */


@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val moveDrawer by remember {
        mutableStateOf(false)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MyTopAppBar(onClickIcon = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(it)
                }
            }, onClickDrawer = {
                coroutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            })
        },
        bottomBar = { MyBottomNavigation() },
        drawerContent = { MyDrawer(){
            coroutineScope.launch {
                scaffoldState.drawerState.close()
            }
        } },
        floatingActionButton = { MyFAB() },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
        drawerGesturesEnabled = moveDrawer //* el navigation no se mueve

    ) {

    }
}


@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClickDrawer: (Boolean) -> Unit) {
    TopAppBar(title = {
        Text(text = "Toolbar test")
    },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickDrawer(true) }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            }

            IconButton(onClick = { onClickIcon("Date range") }) {
                Icon(imageVector = Icons.Filled.DateRange, contentDescription = "date_range")
            }

        }
    )
}

@Composable
fun MyBottomNavigation() {
    var index by remember {
        mutableStateOf(0)
    }
    BottomNavigation(backgroundColor = Color.Red, contentColor = Color.White) {
        BottomNavigationItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = ""
            )
        }, label = { Text(text = "Home") })
        BottomNavigationItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = ""
            )
        }, label = { Text(text = "Favorite") })
        BottomNavigationItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = ""
            )
        }, label = { Text(text = "Person") })
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = Color.Yellow,
        contentColor = Color.Black,
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(imageVector = Icons.Default.Favorite, contentDescription = "")
    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "Primera opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
        Text(
            text = "Segunda opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable { onCloseDrawer()}
        )
        Text(
            text = "Tercera opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable { onCloseDrawer()}
        )
        Text(
            text = "Cuarta opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable { onCloseDrawer()}
        )
    }
}