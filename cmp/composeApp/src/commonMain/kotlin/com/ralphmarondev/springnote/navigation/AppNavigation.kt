package com.ralphmarondev.springnote.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ralphmarondev.springnote.auth.presentation.login.LoginScreen
import com.ralphmarondev.springnote.auth.presentation.register.RegisterScreen
import com.ralphmarondev.springnote.note.presentation.new_note.NewNoteScreen
import com.ralphmarondev.springnote.note.presentation.note_details.NoteDetailsScreen
import com.ralphmarondev.springnote.note.presentation.note_list.NoteListScreen
import com.ralphmarondev.springnote.note.presentation.update_note.UpdateNoteScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Login
    ) {
        composable<Routes.Login> {
            LoginScreen(
                navigateToHome = {
                    navController.navigate(Routes.NoteList) {
                        launchSingleTop = true
                    }
                },
                navigateToRegister = {
                    navController.navigate(Routes.Register) {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable<Routes.Register> {
            RegisterScreen(
                navigateToLogin = {
                    navController.navigateUp()
                }
            )
        }
        composable<Routes.NoteList> {
            NoteListScreen(
                navigateToNewNote = {
                    navController.navigate(Routes.NewNote) {
                        launchSingleTop = true
                    }
                },
                navigateToDetails = { id ->
                    navController.navigate(Routes.NoteDetails(id)) {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable<Routes.NewNote> {
            NewNoteScreen(
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
        composable<Routes.NoteDetails> {
            val id = it.toRoute<Routes.NoteDetails>().id
            NoteDetailsScreen(
                id = id,
                navigateBack = {
                    navController.navigateUp()
                },
                navigateToUpdateNote = { id ->
                    navController.navigate(Routes.UpdateNote(id)) {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable<Routes.UpdateNote> {
            val id = it.toRoute<Routes.UpdateNote>().id
            UpdateNoteScreen(
                noteId = id,
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}