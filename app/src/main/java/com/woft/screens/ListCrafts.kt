package com.woft.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.woft.components.CraftSection
import com.woft.database.Craft


@Composable
fun ListCrafts(navHostController: NavHostController, listCrafts: List<Craft>) {

    Column {
        Text("second String")
        Button({navHostController.navigateUp()}) {
            Text("Back")
        }

        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
//            TODO здесь нужно передавать объекты из дб
            items(listCrafts, key = {it.uid}) {
                CraftSection(craft = it)
            }
        }
    }


}