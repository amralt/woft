package com.woft.components

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.woft.database.Craft
import com.woft.ui.theme.view.MainViewModel

@Composable
fun CraftSection(
//    @DrawableRes drawable: Int,
    craft: Craft,
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    vm: MainViewModel
) {
    val viewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
    Surface(
        shape = MaterialTheme.shapes.medium,
        //color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth(1f),
//        shadowElevation = CardDefaults.cardElevation(10.dp),
        border = BorderStroke(3.dp, Color.Gray),
        onClick = {
            viewModel.changeCraft(craft)
            navHostController.navigate("main")
        }

    ) {
        Card {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(255.dp)
            ) {
    //            Image(
    //                painter = painterResource(drawable),
    //                contentDescription = null,
    //                contentScale = ContentScale.Crop,
    //                modifier = Modifier.size(80.dp)
    //            )

                craft.craftName?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                craft.description?.let {
                    Text(
            //                    text = stringResource(craft.description),
                        text = it,
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(6.dp),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.Gray,
//                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}
