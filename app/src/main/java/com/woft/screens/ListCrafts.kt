package com.woft.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.woft.components.CraftSection
import com.woft.database.Craft
import java.lang.reflect.Modifier


@Composable
fun ListCrafts(navHostController: NavHostController, listCrafts: List<Craft>) {

    Column (
        modifier = androidx.compose.ui.Modifier.fillMaxSize()
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = androidx.compose.ui.Modifier
                .background(MaterialTheme.colorScheme.outline)
                .fillMaxHeight(0.1f)
                .fillMaxWidth(1f)

        ) {
            Text("Список советов")
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.9f)
        ) {
            items(listCrafts, key = { it.uid }) {
                CraftSection(craft = it, navHostController = navHostController)
            }
        }

        Column(
            horizontalAlignment = Alignment.End,
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
                        Text("Инструкция")
                    },
                    selected = true,
                    onClick = { navHostController.navigate("main") }
                )

            }
        }
    }


}