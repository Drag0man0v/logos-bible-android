package com.example.logos.domain.repositoryInterfaces

import com.example.logos.domain.model.BibleVerse
import com.example.logos.domain.model.Translation
import kotlinx.coroutines.flow.Flow

interface BibleVerseRepository {
    suspend fun downloadTranslation(translation: Translation)

    fun getChapter(book: Int, chapter: Int, translation: Translation): Flow<List<BibleVerse>>

    fun getVercesByText(text: String): Flow<List<BibleVerse>>

    fun getVercesByTextAndTranslate(translation: Translation, text: String): Flow<List<BibleVerse>>

    suspend fun isTranslationDownloaded(translation: Translation): Boolean
}