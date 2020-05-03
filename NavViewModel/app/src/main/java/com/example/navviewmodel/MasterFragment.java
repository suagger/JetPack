package com.example.navviewmodel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.navviewmodel.databinding.FragmentMasterBinding;


public class MasterFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMasterBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_master,container,false);
        final MyViewModel viewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        binding.setData(viewModel);
        binding.setLifecycleOwner(getActivity());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_masterFragment_to_detailFragment);
            }
        });

        binding.seekBar.setProgress(viewModel.getNumber().getValue());

        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                viewModel.getNumber().setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return binding.getRoot();
    }
}
