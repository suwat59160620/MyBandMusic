package buu.informatics.s59160620.mybandmusic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")

class MusicDatabaseModels (
    @PrimaryKey(autoGenerate = true)
    var Id: Int = 0,

    @ColumnInfo(name = "name_band")
    var nameBand: String,

    @ColumnInfo(name = "name_music")
    var nameMusic: String,

    @ColumnInfo(name = "url_music")
    var urlMusic: String
)