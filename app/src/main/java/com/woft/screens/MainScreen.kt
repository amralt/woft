package com.woft.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.woft.database.Craft

@Composable
fun MainScreen(
    navHostController: NavHostController,
    currentCraft: String,
    craft: Craft?,
    onChangeButtonClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.outline)
                .fillMaxHeight(0.15f)
                .fillMaxWidth(1f)

        ) {
            if (craft != null) {
                Text(craft.craftName!!)
            }
        }

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxSize()
        ) {


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
                    onClick = { navHostController.navigate("craftList") }
                )

            }
        }

    }
}