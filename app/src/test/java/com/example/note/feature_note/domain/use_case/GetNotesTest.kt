package com.example.note.feature_note.domain.use_case

import com.example.note.feature_note.data.repository.MockNoteRepository
import com.example.note.feature_note.domain.model.Note
import com.example.note.feature_note.domain.util.NoteOrder
import com.example.note.feature_note.domain.util.OrderType
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetNotesTest{

    private lateinit var getNotes: GetNotes
    private lateinit var mockRepository: MockNoteRepository
    @Before
    fun setUp(){
        mockRepository = MockNoteRepository()
        getNotes = GetNotes(mockRepository)

        val notesToInsert = mutableListOf<Note>()

        ('a'..'z').forEachIndexed { index, c ->
            notesToInsert.add(Note(
                title = c.toString(),
                content = c.toString(),
                timestamp = index.toLong(),
                color = index,
                id = index
            ))
        }
        notesToInsert.shuffle()

        runBlocking {
            notesToInsert.forEach{ mockRepository.insertNote(it) }
        }
    }

    @Test
    fun `Order Notes by Title Ascending, Correct`() = runBlocking {
        val notes = getNotes(NoteOrder.Title(OrderType.Ascending)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].title).isLessThan(notes[i+1].title)
        }
    }

    @Test
    fun `Order Notes by Title Descending, Correct`() = runBlocking {
        val notes = getNotes(NoteOrder.Title(OrderType.Descending)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].title).isGreaterThan(notes[i+1].title)
        }
    }

    @Test
    fun `Order Notes by Date Ascending, Correct`() = runBlocking {
        val notes = getNotes(NoteOrder.Date(OrderType.Ascending)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].timestamp).isLessThan(notes[i+1].timestamp)
        }
    }

    @Test
    fun `Order Notes by Date Descending, Correct`() = runBlocking {
        val notes = getNotes(NoteOrder.Date(OrderType.Descending)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].timestamp).isGreaterThan(notes[i+1].timestamp)
        }
    }

    @Test
    fun `Order Notes by Color Ascending, Correct`() = runBlocking {
        val notes = getNotes(NoteOrder.Color(OrderType.Ascending)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].color).isLessThan(notes[i+1].color)
        }
    }

    @Test
    fun `Order Notes by Color Descending, Correct`() = runBlocking {
        val notes = getNotes(NoteOrder.Color(OrderType.Descending)).first()

        for (i in 0..notes.size - 2){
            assertThat(notes[i].title).isGreaterThan(notes[i+1].title)
        }
    }
}