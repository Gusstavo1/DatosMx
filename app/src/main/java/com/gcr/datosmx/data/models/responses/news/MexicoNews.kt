package com.gcr.datosmx.data.models.responses.news

data class MexicoNews(
        val articles: List<Article>,
        val status: String,
        val totalResults: Int
)