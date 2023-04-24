package com.example.fragmentapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class Fragment3 extends Fragment {



    private static String ARG_Name ;
    private static String ARG_Kay = "name";
    private TextView textView_recived;
    private onClickCheckBokListener mlistener;
    private CheckBox MyCheckBox ;

    private Button button ;


    public Fragment3() {
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof Fragment3.onClickCheckBokListener){
            mlistener = (Fragment3.onClickCheckBokListener) context;
        }else {
            throw new ClassCastException("falid");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mlistener=null;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      Bundle bundle =getArguments();
      if (bundle!=null) {
          ARG_Name = bundle.getString(ARG_Kay);
      }
    }
    public static Fragment3 newInstance(String name){
        Bundle bundle = new Bundle();
        bundle.putString("name" , name);
        Fragment3 fragment3 = new Fragment3();
        fragment3.setArguments(bundle);
        return fragment3;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_3, container, false);
        textView_recived= v.findViewById(R.id.textView_recived);
        MyCheckBox= v.findViewById(R.id.MyCheckBox);
        button = v.findViewById(R.id.button_Continue);
        textView_recived.setText(ARG_Name);
        return v;
    }


    Fragment3.onClickCheckBokListener onClickCheckBokListener = new Fragment3.onClickCheckBokListener(){

        @Override
        public void onClickCheckBok() {
            if (MyCheckBox.isChecked()){
                button.setEnabled(false);
                button.setText("Finshed");
            }else{
                button.setEnabled(true);
            }
        }
    };


    public interface onClickCheckBokListener{
        void onClickCheckBok ();
    }










}