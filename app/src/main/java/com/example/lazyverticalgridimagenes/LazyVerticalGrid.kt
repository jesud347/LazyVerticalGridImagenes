package com.example.lazyverticalgridimagenes

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyVerticalGridTareas(modifier: Modifier) {
    val context = LocalContext.current
    val listaTareas = remember { mutableStateListOf(*getListaTareas().toTypedArray()) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(listaTareas) { item ->
            ItemTareaGrid(model = item) {
                Toast.makeText(context, "${item.titulo} ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ItemTareaGrid(model: Model, onItemSelected: (Model) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(model) }
            .padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = model.imagen),
                contentDescription = model.titulo,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = model.titulo,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 16.sp,
                    color = androidx.compose.ui.graphics.Color.Black
                )
            )
        }
    }
}


fun getListaTareas(): List<Model>{
    return listOf(
        Model( "Estudiar Acceso a Datos", R.drawable.estudiar),
        Model( "Terminar PowerPoint", R.drawable.powerpoint),
        Model( "Entregar el Proyecto", R.drawable.proyecto),
        Model( "Comer hamburguesa", R.drawable.burguer),
        Model( "Sacar al perro", R.drawable.perro),
        Model( "Estudiar Acceso a Datos", R.drawable.estudiar),
        Model( "Terminar PowerPoint", R.drawable.powerpoint),
        Model( "Entregar el Proyecto", R.drawable.proyecto),
        Model( "Comer hamburguesa", R.drawable.burguer),
        Model( "Sacar al perro", R.drawable.perro),
        Model( "Estudiar Acceso a Datos", R.drawable.estudiar),
        Model( "Jugar al fornite", R.drawable.fornite))
}