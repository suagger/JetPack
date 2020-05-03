package com.example.navdemo;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = getView().findViewById(R.id.editText);
//                传递信息
                String key = editText.getText().toString();
                if(TextUtils.isEmpty(key)){
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("my_name",key);
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_homeFragment_to_detailFragment,bundle);
            }
        });

    }
}
