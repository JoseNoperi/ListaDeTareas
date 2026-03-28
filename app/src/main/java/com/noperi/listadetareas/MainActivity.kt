package com.noperi.listadetareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.room.Room
import com.noperi.listadetareas.data.AppDatabase
import com.noperi.listadetareas.data.TaskViewModel
import com.noperi.listadetareas.data.TaskViewModelFactory
import com.noperi.listadetareas.data.repository.TaskRepositoryImpl
import com.noperi.listadetareas.ui.TaskApp
import com.noperi.listadetareas.ui.theme.ListaDeTareasTheme

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "tasks_db"
        ).build()
    }

    private val repository by lazy { TaskRepositoryImpl(db.taskDao()) }

    private val viewModel: TaskViewModel by viewModels {
        TaskViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaDeTareasTheme {
                TaskApp(viewModel)
            }
        }
    }
}