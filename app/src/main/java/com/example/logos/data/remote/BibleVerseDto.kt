package com.example.logos.data.remote

data class BibleVerseDtoX(
    val book: Int,
    val chapter: Int,
    val pk: Int,
    val text: String,
    val translation: String,
    val verse: Int
)