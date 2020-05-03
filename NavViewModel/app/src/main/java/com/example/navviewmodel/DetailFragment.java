package com.example.navviewmodel;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navviewmodel.databinding.FragmentDetailBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDetailBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false);

        final MyViewModel viewModel = new ViewModelProvider(getActivity()).get(MyViewModel.class);
        binding.setData(viewModel);
        binding.setLifecycleOwner(getActivity());

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.add(1);
            }
        });

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_detailFragment_to_masterFragment);
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.add(-1);
            }
        });
        return binding.getRoot();
    }

}
