package com.example.taskmanagementappchallenge.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.taskmanagementappchallenge.data.TaskItem

@Composable
fun TaskColumn(
    modifier: Modifier = Modifier,
    list: List<TaskItem>,
    onTaskClicked: (itemId: Int) -> Unit
) {

    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(vertical = 25.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
    ) {
        items(
            items = list, key = { item -> item.id })
        { item: TaskItem ->
            TaskItem(taskItem = item, onClick = { onTaskClicked(item.id) })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskItem(
    modifier: Modifier = Modifier,
    taskItem: TaskItem,
    onClick: () -> Unit
) {
    Surface(
        shadowElevation = 4.dp,
        modifier = modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(horizontal = 20.dp)
            .clip(MaterialTheme.shapes.large),
        onClick = onClick
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = taskItem.title,
                        textDecoration = if (taskItem.isCompleted) TextDecoration.LineThrough else TextDecoration.None,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Product team", style = MaterialTheme.typography.bodyMedium
                    )
                }
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "Done",
                    tint = Color.White,
                    modifier = Modifier
                        .size(28.dp)
                        .background(
                            color = if (taskItem.isCompleted) MaterialTheme.colorScheme.secondary
                            else Color.Transparent,
                            shape = CircleShape
                        )
                        .border(
                            width = 1.dp,
                            color = if (taskItem.isCompleted) Color.Transparent else MaterialTheme.colorScheme.onTertiary,
                            shape = CircleShape
                        )
                        .padding(6.dp)
                )
            }
            Divider(
                thickness = 0.5.dp,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 10.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Today", style = MaterialTheme.typography.labelSmall
                )
                Text(
                    text = "10:00 AM - 15:00 PM",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}