package com.woft.database.scripts

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.woft.database.Craft
import com.woft.database.CraftsDao

@Database(entities = [Craft::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun craftsDao(): CraftsDao
}