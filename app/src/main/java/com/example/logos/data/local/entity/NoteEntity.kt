package com.example.logos.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val translation: String,
    val book: Int,
    val chapter: Int,
    val startVerse: Int,
    val endVerse: Int,

    val selectionStart: Int? = null, // from which character of the first verse
    val selectionEnd: Int? = null,  // up to which character of the last verse
    val selectedText: String? = null,


    val comment: String? = null,

    val createdAt: Long,
    val updatedAt: Long? = null
)
