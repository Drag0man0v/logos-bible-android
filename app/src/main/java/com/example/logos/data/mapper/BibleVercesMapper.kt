package com.example.logos.data.mapper

import com.example.logos.data.local.entity.BibleVerseEntity
import com.example.logos.data.remote.BibleVerseDto
import com.example.logos.domain.model.BibleVerse
import com.example.logos.domain.model.Translation

fun BibleVerseDto.toEntity(): BibleVerseEntity{
    return BibleVerseEntity(
        id = this.id,
        translation,
        book,
        chapter,
        verse,
        text
    )
}

fun BibleVerseEntity.toModel(): BibleVerse{
    return BibleVerse(
        id,
        Translation.valueOf(translation),// Parse string into Translation enum
        book,
        chapter,
        verse,
        text
    )
}