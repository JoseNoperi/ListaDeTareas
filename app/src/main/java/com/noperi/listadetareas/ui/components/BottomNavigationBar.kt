package com.noperi.listadetareas.ui.components

import com.noperi.listadetareas.ui.theme.GuindaUES
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    NavigationBar(containerColor = GuindaUES) {
        NavigationBarItem(
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) },
            label = { Text("Pendientes", color = androidx.compose.ui.graphics.Color.White) },
            icon = { Icon(Icons.Default.List, contentDescription = "Pendientes", tint = androidx.compose.ui.graphics.Color.White) }
        )
        NavigationBarItem(
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) },
            label = { Text("Completadas", color = androidx.compose.ui.graphics.Color.White) },
            icon = { Icon(Icons.Default.Check, contentDescription = "Completadas", tint = androidx.compose.ui.graphics.Color.White) }
        )
    }
}