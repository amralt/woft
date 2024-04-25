package com.woft.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CraftsDao {
    @Query("SELECT * FROM craft")
    fun getAll(): Flow<List<Craft>>

    @Query("SELECT * FROM craft WHERE uid IN (:craftIds)")
    fun loadAllByIds(craftIds: IntArray): List<Craft>

    @Query("SELECT * FROM craft WHERE craft_name LIKE :name  ")
    fun findByCraftName(name: String): Craft

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(crafts: List<Craft>)

    @Delete
    fun delete(craft: Craft)
}