package org.example.project

import androidx.compose.ui.graphics.painter.Painter

data class Item(
    val categoryTitle: String,
    val categoryImage: Painter,
    val categoryText: String)
