package com.example.logos.di

import com.example.logos.data.local.dao.NoteDao
import com.example.logos.data.repository.NoteRepositoryImpl
import com.example.logos.domain.repositoryInterfaces.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule{

    //instead of this we can use @binds
    // @Binds
    // abstract fun bindNoteRepository(impl: NoteRepositoryImpl): NoteRepository
    @Provides
    @Singleton
    fun provideNoteRepository(note: NoteDao): NoteRepository{
        return NoteRepositoryImpl(note)
    }


}