package com.ralphmarondev.springnote.note.presentation.note_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ralphmarondev.springnote.core.settings.LocalThemeSettings
import com.ralphmarondev.springnote.core.util.isDesktop
import com.ralphmarondev.springnote.note.presentation.components.NoteCard
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(ExperimentalMaterial3Api::class, KoinExperimentalAPI::class)
@Composable
fun NoteListScreen(
    navigateToNewNote: () -> Unit
) {
    val themeSettings = LocalThemeSettings.current
    val viewModel: NoteListViewModel = koinViewModel()
    val notes = viewModel.notes.collectAsState().value
    var isRefreshing by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Notes"
                    )
                },
                actions = {
                    AnimatedVisibility(visible = isDesktop()) {
                        IconButton(
                            onClick = { viewModel.refresh(onDone = {}) }
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Refresh,
                                contentDescription = "Refresh"
                            )
                        }
                    }
                    IconButton(
                        onClick = themeSettings::toggleDarkMode
                    ) {
                        val imageVector = if (themeSettings.darkModeFlow.value) {
                            Icons.Outlined.LightMode
                        } else {
                            Icons.Outlined.DarkMode
                        }
                        Icon(
                            imageVector = imageVector,
                            contentDescription = "Toggle theme"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = navigateToNewNote) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "New note"
                )
            }
        }
    ) { innerPadding ->
        PullToRefreshBox(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            isRefreshing = isRefreshing,
            onRefresh = {
                isRefreshing = true
                viewModel.refresh(
                    onDone = {
                        isRefreshing = false
                    }
                )
            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = notes,
                    key = { note -> note.id }
                ) { note ->
                    NoteCard(
                        note = note,
                        modifier = Modifier
                            .widthIn(max = 500.dp)
                            .fillMaxWidth()
                    )
                }
                item { Spacer(modifier = Modifier.height(100.dp)) }
            }
        }
    }
}