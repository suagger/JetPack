package com.example.calculationtest;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calculationtest.databinding.FragmentQuestionBinding;
import com.example.calculationtest.databinding.FragmentTitleBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final FragmentQuestionBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_question,container,false);
        final MyViewModel viewModel = new ViewModelProvider(requireActivity(), new SavedStateViewModelFactory(getActivity().getApplication(), this)).get(MyViewModel.class);
        viewModel.getCurrentScore().setValue(0);
        viewModel.generator();
        binding.setData(viewModel);
        binding.setLifecycleOwner(requireActivity());
        final StringBuilder builder = new StringBuilder();
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()){
                    case R.id.button_0:
                        builder.append(0);
                        break;
                    case R.id.button_1:
                        builder.append(1);
                        break;
                    case R.id.button_2:
                        builder.append(2);
                        break;
                    case R.id.button_3:
                        builder.append(3);
                        break;
                    case R.id.button_4:
                        builder.append(4);
                        break;
                    case R.id.button_5:
                        builder.append(5);
                        break;
                    case R.id.button_6:
                        builder.append(6);
                        break;
                    case R.id.button_7:
                        builder.append(7);
                        break;
                    case R.id.button_8:
                        builder.append(8);
                        break;
                    case R.id.button_9:
                        builder.append(9);
                        break;
                    case R.id.button_clear:
                        builder.setLength(0);
                        break;
                }
                if(builder.length() == 0){
                    binding.sum1.setText("Your Answer:");
                }else{
                    binding.sum1.setText(builder.toString());
                }
            }
        };

        binding.button0.setOnClickListener(listener);
        binding.button1.setOnClickListener(listener);
        binding.button2.setOnClickListener(listener);
        binding.button3.setOnClickListener(listener);
        binding.button4.setOnClickListener(listener);
        binding.button5.setOnClickListener(listener);
        binding.button6.setOnClickListener(listener);
        binding.button7.setOnClickListener(listener);
        binding.button8.setOnClickListener(listener);
        binding.button9.setOnClickListener(listener);
        binding.buttonClear.setOnClickListener(listener);
        binding.buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(! (builder.length() == 0))
                    if(Integer.valueOf(builder.toString()).intValue() == viewModel.getAnswer().getValue()){
                        viewModel.answerCorrect();
                        builder.setLength(0);
                        binding.sum1.setText("Correct,Go on!");
                    }else{
                        NavController controller = Navigation.findNavController(v);
                        if (viewModel.win_flag){
                            controller.navigate(R.id.action_questionFragment_to_winFragment);
                            viewModel.win_flag = false;
                            viewModel.save();
                        }else {
                            controller.navigate(R.id.action_questionFragment_to_loseFragment);
                        }
                    }
            }
        });
        return binding.getRoot();
    }

}
