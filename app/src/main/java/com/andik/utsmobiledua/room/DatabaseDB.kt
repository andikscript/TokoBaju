package com.andik.utsmobiledua.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andik.utsmobiledua.model.Barang

@Database(entities = [Barang::class], version = 1)
abstract class DatabaseDB : RoomDatabase() {

    abstract fun daoBarang() : DaoBarang

    companion object {

        private var INSTANCE : DatabaseDB? = null

        fun getInstance(context: Context) : DatabaseDB? {
            if (INSTANCE == null) {
                synchronized(DatabaseDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseDB::class.java, "databaseBarang"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroInstance() {
            INSTANCE = null
        }
    }
}