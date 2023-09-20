package com.example.taskmanagementappchallenge.data

data class TaskItem(
    val id: Int,
    var isCompleted: Boolean = false,
    val title: String,
    val description: String,
    val date: String,
    val time: String
)