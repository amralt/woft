package com.woft.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


@Composable
fun ListCrafts(navHostController: NavHostController) {
    Column {
        Text("second String")
        Button({navHostController.navigateUp()}) {
            Text("Back")
        }
    }


}