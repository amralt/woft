package com.woft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.woft.database.scripts.AppDatabase
import com.woft.navigation.AppNavigation
import com.woft.ui.theme.WoftTheme
import com.woft.ui.theme.view.MainViewModel

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "crafts.db"
        ).build()
    }

//    private val viewModel by viewModels<MainViewModel>(
//            factoryProducer = {
//                object : ViewModelProvider.Factory {
//                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//                        return MainViewModel() as T
//                    }
//                }
//            }
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            WoftTheme {
                val viewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
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