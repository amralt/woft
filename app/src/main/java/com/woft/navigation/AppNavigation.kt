package com.woft.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.woft.screens.ListCrafts
import com.woft.screens.MainScreen
import com.woft.ui.theme.view.MainViewModel

/**
 * отвечтает за NavHost
 */
@Composable
fun AppNavigation(navHostController: NavHostController) {
    // navController -   startDestination

    NavHost(navController = navHostController, startDestination = "main") {
        composable("main") {
            val uiState = viewModel<MainViewModel>().text.collectAsState()
            MainScreen(navHostController, uiState.value, {it})

        }
        composable("second") {
            ListCrafts(navHostController)
        }
    }
}

