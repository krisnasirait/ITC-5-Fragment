package com.project.fragmentimplementation;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SellFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SellFragment extends Fragment {
    private Button dumpBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sell, container, false);
        dumpBtn = view.findViewById(R.id.btn_dumpdoge);

        dumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dBuilder = new AlertDialog.Builder(getContext());
                View dumpDialog = getLayoutInflater().inflate(R.layout.fragment_dump_dialog, null);
                Context context = dumpDialog.getContext();
                dBuilder.setView(dumpDialog);
                final AlertDialog alertDialog = dBuilder.create();
                alertDialog.show();

            }
        });
        return view;
    }
}