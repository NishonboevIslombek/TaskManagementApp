package com.example.taskmanagementappchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.taskmanagementappchallenge.data.TabItem
import com.example.taskmanagementappchallenge.data.TaskItem
import com.example.taskmanagementappchallenge.ui.composables.TabRow
import com.example.taskmanagementappchallenge.ui.composables.TaskColumn
import com.example.taskmanagementappchallenge.ui.composables.TopBar
import com.example.taskmanagementappchallenge.ui.theme.TaskManagementAppChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagementAppChallengeTheme {
                TaskManagementAppPortrait()
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val taskList = remember { testTaskList.toMutableStateList() }
    val tabList = remember { testTabList.toMutableStateList() }

    Column(modifier = modifier) {
        TopBar()

        TabRow(
            modifier = modifier.padding(vertical = 10.dp),
            tabList = tabList,
            onTabSelected = { index ->
                for (i in tabList.indices) {
                    tabList[i] = tabList[i].copy(isSelected = false)
                }
                tabList[index] = tabList[index].copy(isSelected = true)
            })

        TaskColumn(
            list = if (tabList[1].isSelected) taskList.filter { !it.isCompleted }
            else if (tabList[2].isSelected) taskList.filter { it.isCompleted }
            else taskList,
            onTaskClicked = { id ->
                taskList.find { it.id == id }?.let { task ->
                    task.isCompleted = !task.isCompleted
                }
                tabList[1] =
                    tabList[1].copy(numberOfTask = taskList.count { task -> !task.isCompleted })
                tabList[2] =
                    tabList[2].copy(numberOfTask = taskList.count { task -> task.isCompleted })
            })
    }
}


@Composable
fun TaskManagementAppPortrait(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFFF9F9F9)
    ) {
        HomeScreen()
    }
}

val testTaskList: List<TaskItem> = listOf(
    TaskItem(
        id = 1,
        isCompleted = false,
        title = "Client Review & Feedback",
        description = "Cypto Wallet Redesign",
        date = "Today",
        time = "10:00 PM - 11:45 PM"
    ),
    TaskItem(
        id = 2,
        isCompleted = false,
        title = "Create Wireframe",
        description = "Cypto Wallet Redesign",
        date = "Today",
        time = "09:15 PM - 10:00 PM"
    ),
    TaskItem(
        id = 3,
        isCompleted = false,
        title = "Review with Client",
        description = "Product team",
        date = "Today",
        time = "01:00 PM - 03:00 PM"
    ),
    TaskItem(
        id = 4,
        isCompleted = false,
        title = "Ideation",
        description = "Product team",
        date = "Today",
        time = "9:10 AM - 11:00 AM"
    )
)

val testTabList: List<TabItem> = listOf(
    TabItem(
        isSelected = true,
        label = "All",
        numberOfTask = testTaskList.size
    ),
    TabItem(
        label = "Open",
        numberOfTask = testTaskList.count { !it.isCompleted }),
    TabItem(
        label = "Closed",
        numberOfTask = testTaskList.count { it.isCompleted })
)



