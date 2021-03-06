package com.gcr.datosmx.data.models.responses.news

data class Article(
        val content: String,
        val description: String,
        val publishedAt: String,
        val source: Source,
        val title: String,
        val url: String,
        val urlToImage: String
)