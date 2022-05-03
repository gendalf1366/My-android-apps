package ru.gendalf13666.rickandmorty.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.gendalf13666.rickandmorty.Model.Repository

class SharedViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SharedViewModel(repository) as T
    }
}
