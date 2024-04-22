package com.woft.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Craft(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "craft_name") val craftName: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "pic_path") val picPath: String?
)