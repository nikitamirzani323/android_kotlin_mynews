package com.example.mynews.Model

data class Article(
    val content: String,
    val description: String,
    val image: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String
)