package com.example.logos.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.logos.data.local.entity.BibleVerseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BibleVerseDao {
    @Upsert()
    suspend fun insert(verse: BibleVerseEntity)

    @Upsert()
    suspend fun insert(verces: List<BibleVerseEntity>)

    @Query("Select * FROM bibleVerses WHERE translation = :translation and book = :book and chapter = :chapter")
    fun getChapter(translation: String, book: Int, chapter: Int): Flow<List<BibleVerseEntity>>

    @Query("Select * FROM bibleVerses WHERE translation = :translation and book = :book and chapter = :chapter and verse = :verse")
    suspend fun getVerceDefault(translation: String, book: Int, chapter: Int, verse: Int): BibleVerseEntity?

    @Query("Select * FROM bibleVerses WHERE translation = :translation and text LIKE '%' || :text || '%' ")
    fun getVercesByTextAndTranslate(text: String, translation: String): Flow<List<BibleVerseEntity>>

    @Query("Select * FROM bibleVerses WHERE text LIKE '%' || :text || '%' ")
    fun getVercesByText(text: String): Flow<List<BibleVerseEntity>>

    @Query("Select exists(SELECT 1 FROM bibleVerses WHERE translation = :translation)")
    suspend fun isTranslationDownloaded(translation: String): Boolean
}