package com.example.iiflprojecttask.room
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.iiflprojecttask.models.DataList

@Dao
interface DAOAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(resultModel: List<DataList>)

    @Query("SELECT * from script_data")
    fun getAllPosts(): LiveData<List<DataList>>


   /* @Query("SELECT * FROM Login WHERE Username =:username")
    fun getLoginDetails(username: String?) : LiveData<LoginTableModel>
*/
}