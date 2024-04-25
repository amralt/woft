package com.woft.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.woft.database.Craft
import com.woft.screens.ListCrafts
import com.woft.screens.MainScreen
import com.woft.ui.theme.view.MainViewModel

/**
 * отвечтает за навигацию в приложении 
 */
@Composable
fun AppNavigation(navHostController: NavHostController, stateCraftList: List<Craft>) {

    NavHost(navController = navHostController, startDestination = "main") {
        composable("main") {
            val viewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
            MainScreen(navHostController, {it}, viewModel)

        }

        composable("craftList") {
            val viewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
            val crafts = viewModel.listCraft.collectAsState()
            ListCrafts(navHostController, crafts.value, viewModel)
        }
    }
}

