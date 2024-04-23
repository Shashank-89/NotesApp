package com.example.note.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.note.R
import com.example.note.feature_note.domain.util.NoteOrder
import com.example.note.feature_note.domain.util.OrderType

@Composable
fun NoteOrderSection (
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit,
){
    Column(
        modifier = modifier.padding(4.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Row (
            modifier = modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            DefaultRadioButton(
                text = stringResource(id = R.string.title),
                selected = noteOrder is NoteOrder.Title,
                onSelect = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) }
            )
            
            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = stringResource(id = R.string.date),
                selected = noteOrder is NoteOrder.Date,
                onSelect = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) }
            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = stringResource(id = R.string.color),
                selected = noteOrder is NoteOrder.Color,
                onSelect = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) }
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Row (
            modifier = modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            DefaultRadioButton (
                text = stringResource(id = R.string.descending),
                selected = noteOrder.orderType == OrderType.Descending,
                onSelect = {
                    if(noteOrder.orderType != OrderType.Descending)
                        onOrderChange(noteOrder.createCopy(OrderType.Descending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton (
                text = stringResource(id = R.string.asscending),
                selected = noteOrder.orderType == OrderType.Ascending,
                onSelect = {
                    if(noteOrder.orderType != OrderType.Ascending)
                        onOrderChange(noteOrder.createCopy(OrderType.Ascending))
                }
            )
        }
    }
}