package com.example.mywishlistapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(                    // connect to the room database or inherit the properties of room database
    entities = [Wish::class],
    version = 1,
    exportSchema = false     // true means export the table in json file and send over there, false means not to export
)
abstract class WishDataBase : RoomDatabase(){
    abstract fun wishDao(): WishDao    //  There will be no way to access the DAO, making it impossible to perform database operations.

}