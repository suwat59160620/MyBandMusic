package buu.informatics.s59160620.mybandmusic.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MusicDatabaseModels::class], version = 2, exportSchema = false)

abstract class MusicDatabase : RoomDatabase() {

    abstract fun MusicDatabaseModels(): MusicDAO

    companion object {

        @Volatile
        private var INSTANCE:MusicDatabase? = null

        fun getInstance(context: Context): MusicDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MusicDatabase::class.java,
                    "Music_database"
                ).allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                // return instance
                instance

            }
        }
    }

}
