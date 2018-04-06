package com.example.minhthanh.lab5_android;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by minh thanh on 4/6/2018.
 */

public class FragmentOption extends AppCompatDialogFragment {


    private TextView btnOK;
    private TextView btnCancel;
    public interface OnInputListenerDelete{
        void sendInputDelete(String Delete);
    }
    public OnInputListenerDelete mOnInputListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_dialog_option,container,false);
        btnOK   = view.findViewById(R.id.button2);
        btnCancel = view.findViewById(R.id.button1);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mOnInputListener.sendInputDelete("Delete");
                getDialog().dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mOnInputListener = (OnInputListenerDelete) context;
        }catch (ClassCastException e){
        }
    }

}
