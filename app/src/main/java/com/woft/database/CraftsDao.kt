package com.woft.database

@Dao
interface CraftsDao {

    @Insert
    suspend fun insert(product: Product)

    @Query("SELECT * FROM product")
    fun getAllProducts(): LiveData<List<Product>>

}