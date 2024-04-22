package com.woft.ui.theme.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.woft.MainActivity
import com.woft.database.scripts.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * работает с данными и является прослойкой между пользователем и ними
 *
 */
class MainViewModel: ViewModel() {
    // obsorval класс полуает данные и при их обновлении они меняются

    val text: MutableStateFlow<String> = MutableStateFlow("hello woft")
    private var job: Job? = null
    fun changeText(newText: String) {
        text.update { newText }
    }

    init {
        job?.cancel() // если не нулл, то отсонавливает карутину
        //Dispatchers - отдельные потоки
        job = viewModelScope.launch(Dispatchers.IO) {
            // job - объект работы, с помощью которого можно останавливать карутину



            val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()


//        здесь нужно обращться в бд
        }
    }
    // flow - это поток данных
}