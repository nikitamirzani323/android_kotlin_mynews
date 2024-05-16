package com.example.mynews.Model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title : String,
    val selectedItem : ImageVector,
    val unselectedItem : ImageVector
)
