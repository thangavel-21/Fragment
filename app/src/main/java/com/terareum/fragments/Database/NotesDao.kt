package com.terareum.fragments.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNotes(notes: AddNotesDataClass)

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun getNotesList() : LiveData<List<AddNotesDataClass>>
}