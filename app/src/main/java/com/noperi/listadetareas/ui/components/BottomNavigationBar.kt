package com.noperi.listadetareas.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun BottomNavigationBar() {
    var selected by remember { mutableStateOf(0) }

    NavigationBar {
        NavigationBarItem(
            selected = selected == 0,
            onClick = { selected = 0 },
            label = { Text("Pendientes") },
            icon = { Icon(imageVector = Icons.Default.List, contentDescription = "Pendientes") }
        )
        NavigationBarItem(
            selected = selected == 1,
            onClick = { selected = 1 },
            label = { Text("Completadas") },
            icon = { Icon(imageVector = Icons.Default.Check, contentDescription = "Completadas") }
        )
    }
}