package com.alpertign.diaryapp.presentation.screens.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime

/**
 * Created by Alperen Acikgoz on 27,July,2023
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onMenuClicked: () -> Unit,
    dateIsSelected: Boolean,
    onDateSelected: (ZonedDateTime) -> Unit,
    onDateReset: () -> Unit,
) {

    val dateDialog = rememberUseCaseState()
    val pickedDate by remember { mutableStateOf(LocalDate.now()) }
    val scope = rememberCoroutineScope()
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = { Text(text = "Diary") },
        navigationIcon = {
            IconButton(onClick = onMenuClicked) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Hamburger Menu Icon",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        actions = {
            if (dateIsSelected) {
                IconButton(onClick = onDateReset) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon ",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            } else {
                IconButton(onClick = { scope.launch { dateDialog.show() } }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Date Icon ",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    )

    CalendarDialog(
        state = dateDialog,
        selection = CalendarSelection.Date { localDate ->
            onDateSelected(
                ZonedDateTime.of(
                    localDate,
                    LocalTime.now(),
                    ZoneId.systemDefault()
                )
            )
        },
        config = CalendarConfig(monthSelection = true, yearSelection = true)
    )
}

