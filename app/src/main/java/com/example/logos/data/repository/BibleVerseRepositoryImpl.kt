package com.example.logos.data.repository

import com.example.logos.data.local.dao.BibleVerseDao
import com.example.logos.data.mapper.toEntity
import com.example.logos.data.mapper.toModel
import com.example.logos.data.remote.BollsApi
import com.example.logos.domain.model.BibleVerse
import com.example.logos.domain.model.Translation
import com.example.logos.domain.repositoryInterfaces.BibleVerseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BibleVerseRepositoryImpl @Inject constructor(private val api: BollsApi, private val bibleVerseDao: BibleVerseDao) : BibleVerseRepository {
    override suspend fun downloadTranslation(translation: Translation) {
        // TODO: Check if current translation has already been added.
        val listOfVerces = api.getFullBible(translation.name)//api response

        val entities = listOfVerces.map{it.toEntity()}//convert

        bibleVerseDao.insert(//add it to the room
            entities
        )

    }

    override fun getChapter(
        book: Int,
        chapter: Int,
        translation: Translation
    ): Flow<List<BibleVerse>> {
        return bibleVerseDao.getChapter(translation.name, book ,chapter).map {
            chapterList -> chapterList.map {
                it.toModel()
            }
        }
    }

    override fun getVercesByText(text: String): Flow<List<BibleVerse>> {
        return bibleVerseDao.getVercesByText(text).map {
            list -> list.map { it.toModel() }
        }
    }

    override fun getVercesByTextAndTranslate(
        translation: Translation,
        text: String
    ): Flow<List<BibleVerse>> {
        return bibleVerseDao.getVercesByTextAndTranslate(text, translation.name).map {
                list -> list.map { it.toModel() }
        }
    }

    override suspend fun isTranslationDownloaded(translation: Translation): Boolean {
        return bibleVerseDao.isTranslationDownloaded(translation.name)
    }


}