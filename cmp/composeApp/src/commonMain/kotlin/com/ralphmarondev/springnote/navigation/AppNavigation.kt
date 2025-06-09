package com.ralphmarondev.springnote.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.springnote.auth.presentation.login.LoginScreen
import com.ralphmarondev.springnote.note.presentation.note_list.NoteListScreen

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
                }
            )
        }
        composable<Routes.NoteList> {
            NoteListScreen()
        }
    }
}