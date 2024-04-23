package com.example.note.feature_note.presentation.add_edit_note

import com.example.note.ui.UIText

data class NoteTextFieldState(
    val text: String = "",
    val hint: UIText = UIText.DynamicString(""),
    val isHintVisible: Boolean = true,
)
