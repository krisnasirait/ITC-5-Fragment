package com.project.fragmentimplementation;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BuyFragment extends Fragment {
    private Button pumpBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy, container, false);
        pumpBtn = view.findViewById(R.id.btn_pumpdoge);

        pumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dBuilder = new AlertDialog.Builder(getContext());
                View pumpDialog = getLayoutInflater().inflate(R.layout.fragment_pump_dialog, null);
                Context context = pumpDialog.getContext();
                dBuilder.setView(pumpDialog);
                final AlertDialog alertDialog = dBuilder.create();
                alertDialog.show();

            }
        });
        return view;
    }
}