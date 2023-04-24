package com.example.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.fragmentapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Fragment2.OnFragmentInterActionListener , Fragment3.onClickCheckBokListener {

    private ActivityMainBinding binding ;
    private  int currentFragment  = 1 ;
    private String name ;
    private Button button_Continue ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Fragment1 fragment1 = Fragment1.newInstance(null , null);
        Fragment2 fragment2 = Fragment2.newInstance(null , null);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container , fragment1)
                .commit();


        binding.buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentFragment==1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , fragment2)
                            .addToBackStack(null)
                            .commit();

                    currentFragment =2 ;
                }else {

                    if (!TextUtils.isEmpty(Fragment2.fragment2Binding.editTextName.getText().toString())){
                        name = Fragment2.fragment2Binding.editTextName.getText().toString();
                        Fragment3 fragment3 = Fragment3.newInstance(name);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , fragment3)
                                .addToBackStack(null)
                                .commit();
                    }else {
                        Toast.makeText(MainActivity.this, "Enter Your Name", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });







    }


    @Override
    public void onFragmentInetAction(String name) {
    }


    @Override
    public void onClickCheckBok() {
    }
}