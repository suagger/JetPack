package com.example.roombasic;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<Word> wordList = new ArrayList<>();

    private MyViewModel myViewModel;
    boolean aSwitch;

    public MyAdapter(boolean aSwitch,MyViewModel myViewModel){
        this.aSwitch = aSwitch;
        this.myViewModel = myViewModel;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view ;
        if(!aSwitch){
            view = inflater.inflate(R.layout.word_item_switch,parent,false);
//            view = inflater.inflate(R.layout.word_item,parent,false);
        }else {
            view = inflater.inflate(R.layout.word_card,parent,false);
        }
        final ViewHolder holder = new ViewHolder(view);
        holder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Word word = (Word) holder.itemView.getTag(R.id.word_for_view_holder);

                if(isChecked){
                    holder.chineseMeaning.setVisibility(View.GONE);
                    word.setChineseInvisible(true);
                    myViewModel.update(word);
                }else{
                    holder.chineseMeaning.setVisibility(View.VISIBLE);
                    word.setChineseInvisible(false);
                    myViewModel.update(word);
                }
            }
        });
        return holder;
    }

//    点击事件性能优化后，放到onCreateView中。
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Word word = wordList.get(position);
        holder.number.setText(String.valueOf(position + 1));
        holder.chineseMeaning.setText(word.getMeaning());
        holder.english.setText(word.getWord());

        holder.itemView.setTag(R.id.word_for_view_holder,word);
//        必须要加这一句 不然会出现问题
//        holder.aSwitch.setOnCheckedChangeListener(null);
        if(word.isChineseInvisible()){
            holder.chineseMeaning.setVisibility(View.GONE);
            holder.aSwitch.setChecked(true);
        }else{
            holder.chineseMeaning.setVisibility(View.VISIBLE);
            holder.aSwitch.setChecked(false);
        }

       /* holder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    holder.chineseMeaning.setVisibility(View.GONE);
                    word.setChineseInvisible(true);
                    myViewModel.update(word);
                }else{
                    holder.chineseMeaning.setVisibility(View.VISIBLE);
                    word.setChineseInvisible(false);
                    myViewModel.update(word);
                }
            }
        });*/
    }
    @Override
    public int getItemCount() {
        return wordList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView english,chineseMeaning,number;
        public Switch aSwitch;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            english = itemView.findViewById(R.id.tv_english);
            chineseMeaning = itemView.findViewById(R.id.tv_chinese_meaning);
            number = itemView.findViewById(R.id.tv_number);
            aSwitch = itemView.findViewById(R.id.chinese_invisiable);
        }
    }
}
