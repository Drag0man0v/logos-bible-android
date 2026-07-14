package com.example.logos.domain.model


data class Note(
    val id: Int,
    val translation: Translation,// in all objects it should be a pointer(bcs its enum)
    val book: Int,
    val chapter: Int,
    val startVerse: Int,
    val endVerse: Int,


    val selectionStart: Int? = null,
    val selectionEnd: Int? = null,
    val selectedText: String? = null,

    val comment: String? = null,

    val createdAt: Long,
    val updatedAt: Long?= null
)
