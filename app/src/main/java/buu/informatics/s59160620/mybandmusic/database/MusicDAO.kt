package buu.informatics.s59160620.mybandmusic.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MusicDAO {

    @Insert
    fun insert(music: MusicDatabaseModels)

    @Update
    fun update(music: MusicDatabaseModels)

    @Query("SELECT * FROM item ORDER BY Id ASC")
    fun get(): LiveData<List<MusicDatabaseModels>>

    @Query("DELETE FROM item")
    fun clear()
}
