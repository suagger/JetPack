package com.example.calculationtest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calculationtest.databinding.FragmentLoseBinding;
import com.example.calculationtest.databinding.FragmentWinBinding;


public class LoseFragment extends Fragment {

    public LoseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        MyViewModel viewModel =
                new ViewModelProvider(requireActivity(),new SavedStateViewModelFactory(getActivity().getApplication(),this)).get(MyViewModel.class);
        FragmentLoseBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_lose,container,false);
        binding.setData(viewModel);
        binding.setLifecycleOwner(requireActivity());
        binding.loseBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_loseFragment_to_titleFragment);
            }
        });
        return binding.getRoot();
//        return inflater.inflate(R.layout.fragment_lose, container, false);
    }

}
