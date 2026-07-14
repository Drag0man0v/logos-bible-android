package com.example.logos.data.mapper

import com.example.logos.data.local.entity.NoteEntity
import com.example.logos.domain.model.Note
import com.example.logos.domain.model.Translation

//extention func
fun NoteEntity.toModel(): Note {
    return Note(
        id = this.id,
        translation = Translation.valueOf(this.translation),//todo add checking and set default value
        book = this.book,
        chapter = this.chapter,
        startVerse = this.startVerse,
        endVerse = this.endVerse,
        selectedText = this.selectedText,
        selectionStart = this.selectionStart,
        selectionEnd = this.selectionEnd,
        createdAt = this.createdAt,
        comment = this.comment,
        updatedAt = this.updatedAt
    )
}

//we can write = instead of {return}
fun Note.toEntity(): NoteEntity = NoteEntity(
    id= this.id,
    translation = this.translation.name,
    book= this.book,
    chapter = this.chapter,
    startVerse = this.startVerse,
    endVerse = this.endVerse,
    selectedText = this.selectedText,
    selectionStart = this.selectionStart,
    selectionEnd = this.selectionEnd,
    createdAt = this.createdAt,
    comment = this.comment,
    updatedAt = this.updatedAt
)