package com.woft.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.woft.database.Craft

@Composable
fun CraftSection(
//    @DrawableRes drawable: Int,
    craft: Craft,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
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
                craft.description?.let {
                    Text(
                        //TODO а нужна ли нам бд если мы можем все засунут ьв ресурсы?
            //                    text = stringResource(craft.description),
                        text = it,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}
