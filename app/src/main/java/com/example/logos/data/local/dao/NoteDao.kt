package com.example.logos.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.logos.data.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao{
    @Upsert()
    suspend fun insert(note: NoteEntity)

    @Delete()
    suspend fun delete(note: NoteEntity)

    @Update// we can write this without ()
    suspend fun update(note: NoteEntity)

    //get sorted value

    //default get
    @Query("SELECT * FROM notes ORDER BY createdAt DESC")
    fun getNewest(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes ORDER BY createdAt ASC")
    fun getOldest(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes where book=:book")
    fun getSortedByBook(book: Int): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE book = :book AND chapter = :chapter")
    fun getForChapter(book: Int, chapter: Int): Flow<List<NoteEntity>>

    @Query("Select * FROM notes where book <= 39")
    fun getOldTestament(): Flow<List<NoteEntity>>

    @Query("Select * FROM notes where book >= 40")
    fun getNewTestament(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE selectedText LIKE '%' || :text || '%' OR comment LIKE '%' || :text || '%'")
    fun getSortedByText(text: String): Flow<List<NoteEntity>>

    @Query("Select * from notes where translation = :translationName")
    fun getFromCurrentTranslation(translationName: String): Flow<List<NoteEntity>>

}
