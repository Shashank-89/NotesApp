package com.example.note.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.note.ui.theme.BabyBlue
import com.example.note.ui.theme.LightGreen
import com.example.note.ui.theme.RedOrange
import com.example.note.ui.theme.RedPink
import com.example.note.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null,
){
    companion object{
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }

    fun isAnagram(s1: String, s2: String): Boolean {
        val s1Char = s1.toCharArray()
        val s2Char = s2.toCharArray()
        s1Char.sort()
        s2Char.sort()
        return String(s1Char) == String(s2Char)
    }

}

class InvalidNoteException(message: String) : Exception(message)
