package com.example.roombasic;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    LiveData<List<Word>> allWords;
    private WordDao wordDao;
    public WordRepository(Context context) {
        WordDataBase dataBase = WordDataBase.getInstance(context.getApplicationContext());
        wordDao = dataBase.getWordDao();
        allWords = wordDao.allWords();
    }
    void insert(Word... words){
        new WordRepository.InsertAsyncTask(wordDao).execute(words);
    }

    void update(Word... words){
        new WordRepository.UpdateAsyncTask(wordDao).execute(words);
    }

    void clear(){
        new WordRepository.ClearAsyncTask(wordDao).execute();
    }

    void delete(Word... words){
        new WordRepository.DeleteAsyncTask(wordDao).execute(words);
    }


    public LiveData<List<Word>> getAllWords() {
        return wordDao.allWords();
    }

    static class InsertAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao wordDao;

        public InsertAsyncTask(WordDao wordDao){
            this.wordDao = wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertWords(words);
            return null;
        }
    }

    static class UpdateAsyncTask extends AsyncTask<Word, Void, Void>{
        private WordDao wordDao;

        public UpdateAsyncTask(WordDao wordDao){
            this.wordDao = wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {
            wordDao.updateWords(words);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<Word, Void, Void>{
        private WordDao wordDao;

        public DeleteAsyncTask(WordDao wordDao){
            this.wordDao = wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteWords(words);
            return null;
        }
    }

    static class ClearAsyncTask extends AsyncTask<Void, Void, Void>{
        private WordDao wordDao;

        private ClearAsyncTask(WordDao wordDao){
            this.wordDao = wordDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAllWords();
            return null;
        }
    }
}
