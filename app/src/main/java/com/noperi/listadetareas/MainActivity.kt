package com.noperi.listadetareas

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.noperi.listadetareas.data.AppDatabase
import com.noperi.listadetareas.data.TaskEntity
import com.noperi.listadetareas.ui.TaskApp
import com.noperi.listadetareas.ui.theme.ListaDeTareasTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "tasks_db"
        ).build()

        val dao = db.taskDao()

        lifecycleScope.launch {
            dao.insertTask(TaskEntity(title = "Prueba 1"))
            val items = dao.getTasks()
            Log.d("ROOM", "Tareas almacenadas: $items")
        }

        setContent {
            ListaDeTareasTheme {
                TaskApp()
            }
        }
    }
}