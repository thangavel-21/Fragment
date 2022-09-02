package com.terareum.fragments.Database

import androidx.lifecycle.LiveData

class NotesRepository (private val notesDao : NotesDao) {
    val getAllNotes : LiveData<List<AddNotesDataClass>> = notesDao.getNotesList()

    suspend fun addNotes(notes : AddNotesDataClass) {
        notesDao.addNotes(notes)
    }
}