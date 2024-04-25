package com.example.note.feature_note.domain.use_case

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.note.feature_note.data.repository.MockNoteRepository
import com.example.note.feature_note.domain.model.InvalidNoteException
import com.example.note.feature_note.domain.model.Note
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertThrows

import org.junit.Before
import org.junit.Test

class AddNoteTest {

    private lateinit var addNote:AddNote
    private lateinit var mockRepository: MockNoteRepository

    @Before
    fun setUp() {
        mockRepository = MockNoteRepository()
        addNote = AddNote(mockRepository)
    }

    @Test
    fun `Add Note by Empty title, throws exception`(){
        val note = Note(
            title = "",
            content = "Content",
            timestamp = 1,
            color = Color.Red.toArgb(),
            id = 1
        )
        val e: InvalidNoteException = assertThrows(InvalidNoteException::class.java){
            runBlocking {
                addNote(note)
            }
        }
        assertThat(e).hasMessageThat().isEqualTo("Note's title can't be empty!!")
    }
}