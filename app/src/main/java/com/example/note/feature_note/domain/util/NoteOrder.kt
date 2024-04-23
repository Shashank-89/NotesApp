package com.example.note.feature_note.domain.util

sealed class NoteOrder(val orderType: OrderType) {
    fun createCopy(type: OrderType): NoteOrder{
        return when(this){
            is Title -> this.copy(type)
            is Color -> this.copy(type)
            is Date -> this.copy(type)
        }
    }
    data class Title(val type: OrderType) : NoteOrder(orderType = type)
    data class Color(val type: OrderType) : NoteOrder(orderType = type)
    data class Date(val type: OrderType) : NoteOrder(orderType = type)
}