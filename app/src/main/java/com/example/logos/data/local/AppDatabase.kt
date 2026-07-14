package com.example.logos.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.logos.data.local.dao.NoteDao
import com.example.logos.data.local.entity.NoteEntity

@Database(
    // list of all entities (tables) in the database
    entities = [NoteEntity::class],//class references
    version = 1
)
// Room will generate NoteDao_Impl() automatically
abstract class AppDatabase: RoomDatabase() {
    abstract val noteDao: NoteDao
}
