package com.example.logos.data.local.dao

import android.adservices.common.AdSelectionSignals
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

    @Update()
    suspend fun update(note: NoteEntity)

    //get sorted value

    //default get
    @Query("SELECT * FROM notes ORDER BY createdAt DESC")
    suspend fun getNewest(): List<NoteEntity>

    @Query("SELECT * FROM notes ORDER BY createdAt ASC")
    suspend fun getOldest(): List<NoteEntity>

    @Query("SELECT * FROM notes where book=:book")
    suspend fun getSortedByBook(book: Int): List<NoteEntity>

    @Query("Select * FROM notes where book <= 39")
    suspend fun getOldTestament(): List<NoteEntity>

    @Query("Select * FROM notes where book >= 40")
    suspend fun getNewTestament(): List<NoteEntity>

    @Query("SELECT * FROM notes WHERE selectedText LIKE '%' || :text || '%' OR comment LIKE '%' || :text || '%'")
    fun getSortedByText(text: String): Flow<List<NoteEntity>>

}
