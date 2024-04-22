package com.woft.database.scripts

import androidx.room.Database
import androidx.room.RoomDatabase
import com.woft.database.Craft

@Database(entities = [Craft::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun craftsDao(): Craft
}