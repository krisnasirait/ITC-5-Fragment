package com.project.fragmentimplementation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int isActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fragmentManager = getSupportFragmentManager();
        BuyFragment buyFragment = new BuyFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(BuyFragment.class.getSimpleName());

        SellFragment sellFragment = new SellFragment();
        Fragment fragment1 = fragmentManager.findFragmentByTag(SellFragment.class.getSimpleName());

        if(!(fragment instanceof BuyFragment)){
            fragmentManager.beginTransaction()
                    .add(R.id.fl_main, buyFragment, BuyFragment.class.getSimpleName())
                    .commit();
            isActive = 1;
        }else if(!(fragment1 instanceof SellFragment)){
            fragmentManager.beginTransaction()
                    .add(R.id.fl_main, sellFragment, SellFragment.class.getSimpleName())
                    .commit();
            isActive = 2;
        }

        ArrayList<Button> buttons = new ArrayList<>();
        int[] idBtn = {
                R.id.btn_buyfragment,
                R.id.btn_sellfragment,
        };

        for (int i = 0; i < idBtn.length; i++){
            buttons.add(findViewById(idBtn[i]));
            buttons.get(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch(v.getId()){
            case R.id.btn_buyfragment:
                if(isActive != 1){
                    fragmentManager.beginTransaction()
                            .replace(R.id.fl_main, new BuyFragment(), BuyFragment.class.getSimpleName())
                            .commit();
                    isActive = 1;
                }
                break;
            case R.id.btn_sellfragment:
                if(isActive != 2){
                    fragmentManager.beginTransaction()
                            .replace(R.id.fl_main, new SellFragment(), SellFragment.class.getSimpleName())
                            .commit();
                    isActive = 2;
                }
                break;
            case R.id.btn_pumpdoge:
                break;

        }
    }
}