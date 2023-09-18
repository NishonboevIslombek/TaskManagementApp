package com.example.taskmanagementappchallenge.ui.composables


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taskmanagementappchallenge.ui.theme.Blue
import com.example.taskmanagementappchallenge.ui.theme.backgroundBlue

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(20.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Today's Task", style = MaterialTheme.typography.labelLarge)
            Text(text = "Wednesday, 11 May", style = MaterialTheme.typography.bodyLarge)
        }

        FilledTonalButton(
            onClick = {}, shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = backgroundBlue)
        ) {
            Text(
                text = "+  New Task",
                style = MaterialTheme.typography.bodyMedium.copy(color = Blue)
            )
        }
    }
}