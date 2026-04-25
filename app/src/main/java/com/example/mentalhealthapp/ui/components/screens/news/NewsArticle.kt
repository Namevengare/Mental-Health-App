package com.example.mentalhealthapp.ui.components.screens.news

data class NewsArticle(
    val pmid: String,
    val title: String,
    val journal: String,
    val publicationDate: String,
    val doi: String?,
    val pubmedUrl: String,
    val fetchedAt: String
)
