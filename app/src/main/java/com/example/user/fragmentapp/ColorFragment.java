package com.example.user.fragmentapp;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ColorFragment extends Fragment {

    private int mColor = Color.WHITE;
    //필수
    public ColorFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_color, container, false);
        view.setBackgroundColor(mColor);
        return view;
    }

    public void setColor(int color){
        mColor = color;

        if(getView()!=null){
            getView().setBackgroundColor(mColor);
        }
    }
}
