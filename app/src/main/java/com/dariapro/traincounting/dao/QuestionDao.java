package com.dariapro.traincounting.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.dariapro.traincounting.entity.Question;

import java.util.List;

@Dao
public interface QuestionDao {

    @Query("SELECT * FROM question")
    LiveData<List<Question>> getAll();

    @Query("SELECT * FROM question WHERE questionId = :id")
    Question getById(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Question question);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Question... questions);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Question question);

    @Delete
    void delete(Question question);

    @Query("DELETE FROM question")
    void deleteAll();

}