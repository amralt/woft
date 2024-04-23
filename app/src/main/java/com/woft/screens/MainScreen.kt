package com.woft.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun MainScreen(
    navHostController: NavHostController,
    textUi: String,
    onChangeButtonClick: (String) -> Unit
) {
    Column {

        Text("Main String")
        Text(textUi)
        Button(onClick = { onChangeButtonClick("new") }) {
            Text("изменить")
        }
//        Button({ navHostController.navigate("second") }) {
//            Text(text = "next")
//        }

        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ) {
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = null
                    )
                },
                label = {
                    Text("к списку")
                },
                selected = true,
                onClick = { navHostController.navigate("second") }
            )

        }
    }
}