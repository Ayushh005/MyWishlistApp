package com.example.mywishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao  // Data Access Object And it ensures what are CRUD operations and how should they work
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)          //  create
    abstract suspend fun addAWish(wishEntity: Wish)

    // Loads all wishes from the wish table
    @Query("Select * from `wish-table`")                     //  read  * -> means one of the data from table
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update                                                  //  update
    abstract suspend fun updateAWish(wishEntity: Wish)

    @Delete                                                  //  delete
    abstract suspend fun deleteAWish(wishEntity: Wish)

    @Query("Select * from `wish-table` where id=:id")
    abstract fun getAWishById(id:Long): Flow<Wish>

}