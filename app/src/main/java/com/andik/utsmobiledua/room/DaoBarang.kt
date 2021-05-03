package com.andik.utsmobiledua.room

import androidx.room.*
import com.andik.utsmobiledua.model.Barang

@Dao
interface DaoBarang {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data : Barang)

    @Query("SELECT * FROM barang ORDER BY id ASC")
    fun getAll() : List<Barang>

    @Query("SELECT * FROM barang WHERE id = :id LIMIT 1")
    fun getById(id : Int) : Barang

    @Delete
    fun delete(data : Barang)

    @Update
    fun update(data : Barang) : Int

    @Query("DELETE FROM barang")
    fun deleteAll() : Int

}