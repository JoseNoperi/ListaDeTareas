package com.noperi.listadetareas.data.repository

import com.noperi.listadetareas.data.TaskDao
import com.noperi.listadetareas.data.TaskEntity
import com.noperi.listadetareas.domain.Task
import com.noperi.listadetareas.domain.TaskRepository

class TaskRepositoryImpl(
    private val dao: TaskDao
) : TaskRepository {
    override suspend fun getTasks(): List<Task> {
        return dao.getTasks().map {
            Task(id = it.id, title = it.title, description = it.description, isDone = it.isDone)
        }
    }

    override suspend fun addTask(task: Task) {
        dao.insertTask(TaskEntity(title = task.title, description = task.description, isDone = task.isDone))
    }

    override suspend fun updateTask(task: Task) {
        dao.updateTask(TaskEntity(id = task.id, title = task.title, description = task.description, isDone = task.isDone))
    }

    override suspend fun deleteTask(task: Task) {
        dao.deleteTask(TaskEntity(id = task.id, title = task.title, description = task.description, isDone = task.isDone))
    }
}