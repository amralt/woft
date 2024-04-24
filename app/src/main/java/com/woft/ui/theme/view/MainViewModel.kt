package com.woft.ui.theme.view

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.woft.database.Craft
import com.woft.database.CraftsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * работает с данными и является прослойкой между пользователем и ними
 *
 */
class MainViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val applicationContext: Context,
): ViewModel() {
    // obsorval класс полуает данные и при их обновлении они меняются

    val currentCraft: MutableStateFlow<String> = MutableStateFlow("hello woft")
    val listCraft: MutableStateFlow<List<Craft>> = MutableStateFlow(listOf<Craft>(
        Craft(
            uid = -1,
            craftName = "Woft",
            description = "Наше приложение поможет вам подготовиться к путешествиям.Здесь вы увидете самые разные советы для начинающих авантюристов.",
            picPath = null
        )
    ))

    private var job: Job? = null
    fun changeText(newText: String) {
        currentCraft.update { newText }
    }

    init {
        job?.cancel() // если не нулл, то отсонавливает карутину
        //Dispatchers - отдельные потоки
        job = viewModelScope.launch(Dispatchers.IO) {
            // job - объект работы, с помощью которого можно останавливать карутину
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()

                return MainViewModel(
                    savedStateHandle,
                    application.applicationContext
                ) as T
            }
        }
    }
    // flow - это поток данных
}