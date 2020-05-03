package com.example.bottonnavigationdemo;

import androidx.lifecycle.ViewModelProvider;
 

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;

public class ThridFragment extends Fragment {

    private ThridViewModel mViewModel;

    private ImageView imageView;

    public static ThridFragment newInstance() {
        return new ThridFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thrid_fragment, container, false);
        imageView = view.findViewById(R.id.imageView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(ThridViewModel.class);

        imageView.setTranslationX(imageView.getTranslationX() + mViewModel.translationx);
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView,"translationX",0,0);
        objectAnimator.setDuration(500);
        objectAnimator.setDuration(500);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(! objectAnimator.isRunning()){
                    int dx = new Random().nextBoolean()?100:-100;
                    mViewModel.translationx+=dx;
                    objectAnimator.setFloatValues(imageView.getTranslationX(),imageView.getTranslationX() + dx);
                    objectAnimator.start();
                }
            }
        });
    }

}
