package com.noperi.listadetareas.ui
import com.noperi.listadetareas.data.TaskViewModel

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.noperi.listadetareas.ui.components.BottomNavigationBar
import com.noperi.listadetareas.ui.components.DrawerContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskApp(viewModel: TaskViewModel) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent()
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Lista de Tareas") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            bottomBar = {
                BottomNavigationBar()
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { /* Acción futura */ }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar tarea")
                }
            }
        ) { innerPadding ->
            MainContent(modifier = Modifier.padding(innerPadding))
        }
    }
}