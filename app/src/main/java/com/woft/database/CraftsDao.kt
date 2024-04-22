package com.woft.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CraftsDao {
    @Query("SELECT * FROM craft")
    fun getAll(): List<Craft>

    @Query("SELECT * FROM craft WHERE uid IN (:craftIds)")
    fun loadAllByIds(craftIds: IntArray): List<Craft>

    @Query("SELECT * FROM craft WHERE craft_name LIKE :name  ")
    fun findByCraftName(name: String): Craft

    @Insert
    fun insertAll(vararg crafts: Craft)

    @Delete
    fun delete(craft: Craft)
}