package com.terareum.fragments.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.terareum.fragments.Database.AddNotesDataClass
import com.terareum.fragments.R

class NotesAdapter(private val context: Context, private val notesList: List<AddNotesDataClass>) :
    RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.notes_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("TAG", "onBindViewHolder: "+notesList[position] )
        holder.bindView(notesList[position])
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(notesList: AddNotesDataClass) {
            notesTitle.text = notesList.title
            notesDate.text = notesList.date
        }

         private val notesTitle: TextView = itemView.findViewById(R.id.notes_title)
         private val notesDate: TextView = itemView.findViewById(R.id.notes_date)
    }
}