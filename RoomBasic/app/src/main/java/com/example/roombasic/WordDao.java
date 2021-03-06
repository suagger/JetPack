package com.example.roombasic;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insertWords(Word ... words);
    @Update
    void updateWords(Word ... words);
    @Delete
    void deleteWords(Word ... words);
    @Query("DELETE FROM WORD")
    void deleteAllWords();//删除所有的
    @Query("SELECT * FROM WORD ORDER BY ID DESC")
    LiveData<List<Word>> allWords();
}
