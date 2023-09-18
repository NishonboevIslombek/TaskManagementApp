package com.example.taskmanagementappchallenge.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanagementappchallenge.data.TabItem

@Composable
fun TabRow(
    modifier: Modifier = Modifier, tabList: List<TabItem>, onTabSelected: (index: Int) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
            .horizontalScroll(rememberScrollState())
            .padding(start = 25.dp, end = 20.dp)
    ) {
        tabList.forEachIndexed { index, s ->
            if (index == 1) {
                Text(
                    text = "|",
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.ExtraBold)
                )
            }
            TabItem(tabItem = s, onClick = { onTabSelected(index) })
        }
    }
}

@Composable
fun TabItem(modifier: Modifier = Modifier, tabItem: TabItem, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable { onClick() }
    ) {
        Text(
            text = tabItem.label,
            style = MaterialTheme.typography.labelSmall.copy(
                fontSize = 18.sp,
                color = if (tabItem.isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onTertiary,
                fontWeight = if (tabItem.isSelected) FontWeight.Bold else FontWeight.Normal
            )
        )
        Text(
            text = "35",
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            ),
            color = Color.White,
            modifier = Modifier
                .padding(start = 5.dp)
                .background(
                    color = if (tabItem.isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onTertiary,
                    RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 6.dp, vertical = 1.dp)
        )
    }
}