package com.example.bottonnavigationdemo;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FirstFragment extends Fragment {

    private FirstViewModel mViewModel;
    private ImageView imageView;

    public static FirstFragment newInstance() {
        return new FirstFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        imageView = view.findViewById(R.id.imageView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(FirstViewModel.class);
        // TODO: Use the ViewModel
        final ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView,"rotation",0,0);
        imageView.setRotation(mViewModel.rotationPostiton);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(! objectAnimator.isRunning()){
//                    旋转的动画，每次旋转100
                    objectAnimator.setFloatValues(imageView.getRotation(),imageView.getRotation() + 100);
                    mViewModel.rotationPostiton += 100;
                    objectAnimator.setDuration(500);
                    objectAnimator.start();
                }
            }
        });
    }

}
