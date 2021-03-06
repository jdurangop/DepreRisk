package com.example.deprerisk.persistence.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BeckInventoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(question: BeckInventoryEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMany(questionList: List<BeckInventoryEntity>)

    @Query("SELECT * FROM ${BeckInventoryEntity.TABLE_NAME}")
    fun getAllQuestions(): LiveData<List<BeckInventoryEntity>>

    @Query("DELETE FROM ${BeckInventoryEntity.TABLE_NAME} WHERE id = :id")
    fun delete(id: Int)

    @Query("DELETE FROM  ${BeckInventoryEntity.TABLE_NAME}")
    fun deleteAll()

}