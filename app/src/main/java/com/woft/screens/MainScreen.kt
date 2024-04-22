package com.woft.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController

@Composable
fun MainScreen(
    navHostController: NavHostController,
    textUi: String,
    onChangeButtonClick: (String) -> Unit
) {
    Column {
//        val textValue by rememberSaveable {
//            mutableStateOf("")
//        }
//
//        TextField(value = textValue, onValueChange = {textValue = it})

        Text("Main String")
        Text(textUi)
        Button(onClick = { onChangeButtonClick("new") }) {
            Text("изменить")
        }
        Button({navHostController.navigate("second")}) {
            Text(text = "next")
        }
    }
}
