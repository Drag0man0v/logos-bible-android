package com.example.logos.data.repository

import com.example.logos.data.local.dao.NoteDao
import com.example.logos.data.mapper.toEntity
import com.example.logos.data.mapper.toModel
import com.example.logos.domain.model.Note
import com.example.logos.domain.model.Translation
import com.example.logos.domain.repositoryInterfaces.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val dao: NoteDao): NoteRepository {

    override suspend fun insert(note: Note){
        dao.insert(note.toEntity())
    }

    override suspend fun delete(note: Note){
        dao.delete(note.toEntity())
    }

    override suspend fun update(note: Note){
        dao.update(note.toEntity())
    }


    override fun getNewest(): Flow<List<Note>>{
        // Map every list emitted by the Flow
        return dao.getNewest().map { entityList->
            // Convert each NoteEntity to Note
            entityList.map { it.toModel() }
        }
    }

    override fun getOldest(): Flow<List<Note>>{
        return dao.getOldest().map {  entityList ->
            entityList.map{ it.toModel() }
        }
    }

    override fun getSortedByBook(book: Int): Flow<List<Note>>{
        return dao.getSortedByBook(book=book).map { entityList ->
            entityList.map { it.toModel() }
        }
    }

    override fun getForChapter(book: Int, chapter: Int): Flow<List<Note>> {
        return dao.getForChapter(book, chapter).map { entityList ->
            entityList.map { it.toModel() }
        }
    }

    override fun getOldTestament(): Flow<List<Note>>{
        return dao.getOldTestament().map { entityList ->
            entityList.map { it.toModel() }
        }
    }

    override fun getNewTestament(): Flow<List<Note>>{
        return dao.getNewTestament().map { entityList ->
            entityList.map { it.toModel() }
        }
    }

    override fun getSortedByText(text: String): Flow<List<Note>>{
        return dao.getSortedByText(text).map { entityList ->
            entityList.map { it.toModel() }
        }
    }

    override fun getFromCurrentTranslation(translationName: Translation): Flow<List<Note>>{
        return dao.getFromCurrentTranslation(translationName.name).map { entityList ->
            entityList.map { it.toModel() }
        }
    }
}