package com.terareum.fragments.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.terareum.fragments.Database.AddNotesDataClass
import com.terareum.fragments.Database.NotesDatabase
import com.terareum.fragments.Database.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(context: Context) : ViewModel() {
    val getAllNote: LiveData<List<AddNotesDataClass>>
    private val repository : NotesRepository

    init {
        val notesDao = NotesDatabase.getDatabase(context).notesDao()
        repository = NotesRepository(notesDao)
        getAllNote = repository.getAllNotes
    }

    fun addNotes(notes : AddNotesDataClass) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNotes(notes)
        }
    }
}