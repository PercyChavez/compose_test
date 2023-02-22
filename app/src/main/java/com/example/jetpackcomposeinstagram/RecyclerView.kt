package com.example.jetpackcomposeinstagram

import android.text.Layout.Alignment
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeinstagram.model.SuperHero
import kotlinx.coroutines.launch

/**
 * Created by PercyChávez on 21, November, 2022.
 * Copyright (c) 2022 Llamafood. All rights reserved.
 */


@Composable
fun SimpleRecyclerView() {
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHero()) {
            SuperHeroView(it){
                Toast.makeText(context, "Click: "+it.superHeroName, Toast.LENGTH_LONG).show()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SimpleRecyclerStickyView() {
    val context = LocalContext.current
    val superHero = getSuperHero().groupBy { it.publisher }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        superHero.forEach{ (publisher, mySuperHero) ->
            stickyHeader { Text(text = publisher) }
            items(mySuperHero) {
                SuperHeroView(it){
                    Toast.makeText(context, "Click: "+it.superHeroName, Toast.LENGTH_LONG).show()
                }
            }
        }
        
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SimpleGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
        items(getSuperHero()) {
            SuperHeroView(it){
                Toast.makeText(context, "Click: "+it.superHeroName, Toast.LENGTH_LONG).show()
            }
        }
    })
}


@Composable
fun SimpleRecyclerControlsView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutinesScope = rememberCoroutineScope()
    Column(){
        LazyColumn(state = rvState, verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.weight(1f)) {
            items(getSuperHero()) {
                SuperHeroView(it){
                    Toast.makeText(context, "Click: "+it.superHeroName, Toast.LENGTH_LONG).show()
                }
            }
        }

        val showButton by remember{
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        if(showButton){
            Button(onClick = {
                coroutinesScope.launch {
                    // return to item 0
                    rvState.animateScrollToItem(0)
                }
            }, modifier = Modifier
                .align(androidx.compose.ui.Alignment.CenterHorizontally)
                .padding(8.dp)) {
                Text(text = "Holis")
            }
        }

    }

}


@Composable
fun SuperHeroView(superHero: SuperHero, onItemClickListener: (SuperHero) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier
        .width(200.dp)
        .clickable { onItemClickListener(superHero) }) {
        Column() {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "super hero avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superHeroName,
                modifier = Modifier.align(androidx.compose.ui.Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(androidx.compose.ui.Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                modifier = Modifier.align(androidx.compose.ui.Alignment.End),
                fontSize = 9.sp
            )
        }
    }
}

fun getSuperHero(): MutableList<SuperHero> {
    val list: MutableList<SuperHero> = mutableListOf()
    list.add(SuperHero("Hero 1", "Heroname 1", "Publisher 1", R.drawable.ic_search_payment_method))
    list.add(SuperHero("Hero 2", "Heroname 2", "Publisher 1", R.drawable.ic_search_payment_method))
    list.add(SuperHero("Hero 3", "Heroname 3", "Publisher 1", R.drawable.ic_search_payment_method))
    list.add(SuperHero("Hero 4", "Heroname 4", "Publisher 4", R.drawable.ic_search_payment_method))
    return list
}