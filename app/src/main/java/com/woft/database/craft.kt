package com.woft.database

@Entity
class craft {
    @PrimaryKey(autoGenerate = true) val id: Int,
    val imagePath: String,
    val name: String,
    val description: String
}