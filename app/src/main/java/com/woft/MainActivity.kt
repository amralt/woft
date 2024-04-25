package com.woft

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.woft.database.Craft
import com.woft.database.scripts.AppDatabase
import com.woft.navigation.AppNavigation
import com.woft.ui.theme.WoftTheme
import com.woft.ui.theme.view.MainViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {


//    private val viewModel by viewModels<MainViewModel>(
//            factoryProducer = {
//                object : ViewModelProvider.Factory {
//                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                        return MainViewModel() as T
//                    }
//                }
//            }
//    )

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)

            LaunchedEffect(key1 = true) {
//                    listOf(
                viewModel.updateCraftList(
                    listOf(
                        Craft(
                            uid = -1,
                            craftName = "Woft",
                            description = "Наше приложение поможет вам подготовиться к путешествиям.Здесь вы увидете самые разные советы для начинающих авантюристов.",
                            picPath = null
                        ),
                        Craft(
                            uid = 1,
                            craftName = "Поход в горы",
                            description = "1. Палатка: она будет служить вам домом на время похода. Выберите палатку, которая подходит для условий, в которых вы будете находиться (например, если вы идете в снежные горы, то нужна палатка, способная выдержать сильные ветра и снег).\n" +
                                    "\n" +
                                    "2. Спальный мешок: он необходим для комфортного сна в холодных условиях. Выберите спальник, который соответствует температурному режиму, в котором вы будете находиться.\n" +
                                    "\n" +
                                    "3. Рюкзак: выберите рюкзак, который вмещает все необходимые вещи и имеет удобную систему переноски.\n" +
                                    "\n" +
                                    "4. Одежда: возьмите с собой теплую одежду, включая куртку, штаны, шапку, перчатки и носки. Также стоит взять сменную одежду на случай, если вы попадете под дождь или снег.\n" +
                                    "\n" +
                                    "5. Обувь: выберите обувь, которая подходит для условий, в которых вы будете находиться. Это может быть трекинговые ботинки или специальные горные ботинки.\n" +
                                    "\n" +
                                    "6. Пища: возьмите с собой достаточное количество пищи, которое будет соответствовать вашим потребностям в энергии.\n" +
                                    "\n" +
                                    "7. Вода: обязательно возьмите с собой достаточное количество воды. Если вы планируете находиться в местах без доступа к воде, то возьмите с собой фильтр для воды.\n" +
                                    "\n" +
                                    "8. Аптечка первой помощи: в ней должны быть лекарства от головной боли, антисептик, пластырь и другие необходимые медикаменты.\n" +
                                    "\n" +
                                    "9. Средства навигации: возьмите с собой карту местности, компас и/или GPS-навигатор.\n" +
                                    "\n" +
                                    "10. Фонарик: он понадобится вам в темное время суток.\n" +
                                    "\n" +
                                    "11. Солнцезащитный крем: он защитит вашу кожу от солнечных ожогов.\n" +
                                    "\n" +
                                    "12. Спички, зажигалка или: они понадобятся вам для разведения костра.\n" +
                                    "\n" +
                                    "13. Кухонные принадлежности: возьмите с собой котелок, ложку, кружку и нож, чтобы иметь возможность поесть во время привалов.",
                            picPath = null
                        )
//                    Craft(
//                        uid = ,
//                        craftName = ,
//                        description = ,
//                        picPath =
//                    )
//                    )
                    )
                )
//                viewModel.updateCraftList(db.craftsDao().getAll())
            }

            val navController = rememberNavController()
            WoftTheme {
                val stateCraftList = viewModel.listCraft.collectAsState().value
                AppNavigation(navController, stateCraftList)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WoftTheme {
        Greeting("Android")
    }
}