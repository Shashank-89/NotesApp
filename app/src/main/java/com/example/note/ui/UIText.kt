package com.example.note.ui

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UIText {

    data class DynamicString(
        val text: String
    ): UIText()

    class StringResource(
        @StringRes val id: Int,
        vararg val args: Any
    ): UIText()

    fun asString(context: Context): String {
        return when(this){
            is DynamicString -> text
            is StringResource -> context.getString(id, *args)
        }
    }

    @Composable
    fun asString(): String {
        return when(this){
            is DynamicString -> text
            is StringResource -> stringResource(id = id, *args)
        }
    }

}