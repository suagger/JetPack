package com.example.roombasic;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
/*
* ViewModel主要职责管理界面数据
* */
public class MyViewModel extends AndroidViewModel {
    WordRepository wordRepository;
    public LiveData<List<Word>> allListWords;
    public MyViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        allListWords = new WordRepository(application).getAllWords();
    }

    void insert(Word... words){
        wordRepository.insert(words);
    }

    void update(Word... words){
        wordRepository.update(words);
    }

    void clear(){
        wordRepository.clear();
    }

    void delete(Word... words){
        wordRepository.delete(words);
    }


}
