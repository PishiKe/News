package com.pishi.news.utils

object Constants {

    const val POLITICS_API_ENDPOINT : String = "search?q=politics"
    const val TECH_API_ENDPOINT : String = "search?q=technology"
    const val SPORTS_API_ENDPOINT : String = "search?=sports"
    const val API_KEY : String = "apiKey"

    const val API_URL = "https://content.guardianapis.com/"
    const val API_KEY_VALUE = "2e9ba958-d6ca-43d8-8b17-e6e8c2a0160f"




data class Politics(
    val response: Response
)

data class Response(
    val currentPage: Int,
    val orderBy: String,
    val pageSize: Int,
    val pages: Int,
    val results: List<Result>,
    val startIndex: Int,
    val status: String,
    val total: Int,
    val userTier: String
)

data class Result(
    val apiUrl: String,
    val id: String,
    val isHosted: Boolean,
    val pillarId: String,
    val pillarName: String,
    val sectionId: String,
    val sectionName: String,
    val type: String,
    val webPublicationDate: String,
    val webTitle: String,
    val webUrl: String
)

}