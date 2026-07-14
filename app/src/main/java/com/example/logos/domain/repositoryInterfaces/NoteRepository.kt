package com.example.logos.domain.repositoryInterfaces

import com.example.logos.domain.model.Note
import com.example.logos.domain.model.Translation
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insert(note: Note)
    suspend fun delete(note: Note)
    suspend fun update(note: Note)

    fun getNewest(): Flow<List<Note>>
    fun getOldest(): Flow<List<Note>>
    fun getSortedByBook(book: Int): Flow<List<Note>>
    fun getForChapter(book: Int, chapter: Int): Flow<List<Note>>
    fun getOldTestament(): Flow<List<Note>>
    fun getNewTestament(): Flow<List<Note>>
    fun getSortedByText(text: String): Flow<List<Note>>
    fun getFromCurrentTranslation(translationName: Translation): Flow<List<Note>>
}