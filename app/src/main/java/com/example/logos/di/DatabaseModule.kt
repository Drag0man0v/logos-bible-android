package com.example.logos.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.logos.data.local.AppDatabase
import com.example.logos.data.local.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module//say that this is hilt module
@InstallIn(SingletonComponent::class)//how long our dependencies will live
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase  {
        return Room.databaseBuilder(context,
                AppDatabase::class.java//object that describes this class(not a variable of this type) in "java format"
                ,"logos_db")
            .build()
    }

    //we need do this for every dao
    @Provides
    @Singleton
    fun provideNoteDao(app: AppDatabase): NoteDao{
        return app.noteDao
    }
}
