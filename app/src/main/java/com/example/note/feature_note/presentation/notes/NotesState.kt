package com.example.note.feature_note.presentation.notes

import com.example.note.feature_note.domain.model.Note
import com.example.note.feature_note.domain.util.NoteOrder
import com.example.note.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val order: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
