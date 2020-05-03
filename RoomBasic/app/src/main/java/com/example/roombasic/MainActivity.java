package com.example.roombasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;
/*
* 对Room进行优化
* 1.使用livedata
* 2.使用单例类
* 3.对数据库的操作不能放在主线程，如果非要在主线程使用，添加allowMainThreadQueries()
* */
public class MainActivity extends AppCompatActivity {
    Button insert,clear;
    TextView textView;
    MyViewModel viewModel;
    MyAdapter adapter,adapter1;
    RecyclerView recyclerView;
    Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new MyViewModel(getApplication());
        insert = findViewById(R.id.btn_insert);

        clear = findViewById(R.id.btn_clear);
       aSwitch = findViewById(R.id.switch_card);
        textView = findViewById(R.id.tv_number);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(false,viewModel);
        adapter1 = new MyAdapter(true,viewModel);
        recyclerView.setAdapter(adapter);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    recyclerView.setAdapter(adapter1);
                }else{
                    recyclerView.setAdapter(adapter);
                }
            }
        });


        viewModel.allListWords.observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                int temp = adapter.getItemCount();
                adapter.setWordList(words);
                adapter1.setWordList(words);
//                在点击switch时避免卡顿
                if(temp != words.size()){
                    adapter.notifyDataSetChanged();//一定要有这句，不然不显示
                    adapter1.notifyDataSetChanged();
                }

            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] english = {
                        "Hello",
                        "World",
                        "Android",
                        "Google",
                        "Studio",
                        "Project",
                        "Database",
                        "Recycler",
                        "View",
                        "String",
                        "Value",
                        "Integer"
                };
                String[] chinese = {
                        "你好",
                        "世界",
                        "安卓系统",
                        "谷歌公司",
                        "工作室",
                        "项目",
                        "数据库",
                        "回收站",
                        "视图",
                        "字符串",
                        "价值",
                        "整数类型"
                };
                for(int i = 0;i<english.length;i++) {
                    viewModel.insert(new Word(english[i],chinese[i]));
                }
//                updateText();
            }
        });

        /*update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("hi","你好啊！");
                word.setId(20);
                viewModel.update(word);
//                updateText();
            }
        });*/
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.clear();
//                updateText();
            }
        });
       /* delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("hi","你好啊！");
                word.setId(25);
                viewModel.delete(word);
//                updateText();
            }
        });*/
    }
    /*void updateText(){
        List<Word> wordList;
        wordList = wordDao.allWords();
        String str = "";
        for(Word word: wordList){
            str += word.getId() + ":" + word.getWord() + "=" + word.getMeaning() + "\n";
        }
        textView.setText(str);
    }*/


}
