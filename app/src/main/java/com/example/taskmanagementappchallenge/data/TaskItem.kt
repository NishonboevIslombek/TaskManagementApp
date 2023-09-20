package com.example.taskmanagementappchallenge.data

data class TaskItem(
    val id: Int,
    var isCompleted: Boolean = false,
    val title: String
)