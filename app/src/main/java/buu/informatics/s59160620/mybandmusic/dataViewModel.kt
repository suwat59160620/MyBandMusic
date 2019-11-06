package buu.informatics.s59160620.mybandmusic

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import buu.informatics.s59160620.mybandmusic.database.MusicDatabase
import buu.informatics.s59160620.mybandmusic.database.MusicDatabaseModels
import kotlinx.coroutines.launch

class dataViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: dataViewModelRepository
    val getAll: LiveData<List<MusicDatabaseModels>>

    init {
        val wordsDao = MusicDatabase.getInstance(application.applicationContext).MusicDatabaseModels()
        repository = dataViewModelRepository(wordsDao)
        getAll = repository.getAll

    }

    fun insert(word:MusicDatabaseModels) = viewModelScope.launch {
        repository.insert(word)
    }

    fun clear() = viewModelScope.launch {
        repository.clear()
    }

    fun get() = viewModelScope.launch {
        repository.get()
    }
}