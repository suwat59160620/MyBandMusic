package buu.informatics.s59160620.mybandmusic

import androidx.lifecycle.LiveData
import buu.informatics.s59160620.mybandmusic.database.MusicDAO
import buu.informatics.s59160620.mybandmusic.database.MusicDatabaseModels

class dataViewModelRepository (private val Dao: MusicDAO) {

    val getAll: LiveData<List<MusicDatabaseModels>> = Dao.get()

    fun insert(words: MusicDatabaseModels) {
        Dao.insert(words)
    }

    fun clear() {
        Dao.clear()
    }
    fun get (){
        Dao.get()
    }
}