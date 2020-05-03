package com.example.roombasic;

import android.content.Context;
import android.print.PrintAttributes;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/*
* 使用单例类
* database实例化是比较耗资源的，所以使用单例类
* */
@Database(entities = Word.class,version = 2,exportSchema = false)
public abstract class WordDataBase extends RoomDatabase {
    private static WordDataBase instance;
    public synchronized static WordDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),WordDataBase.class,"Word")
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return instance;
    }

    public abstract WordDao getWordDao();
    static final Migration MIGRATION_1_2 = new Migration(1,2){

        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE word ADD COLUMN chinese_invisible INTEGER NOT NULL DEFAULT 0");
        }
    };
}
