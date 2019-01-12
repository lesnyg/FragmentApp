package com.lesnyg.user.fragmentapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ColorFragment extends Fragment {

    private int mColor = Color.WHITE;
    //필수
    public ColorFragment() {
    }

    public static ColorFragment newInstance(int color) {
        ColorFragment colorFragment = new ColorFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("color", color);
        colorFragment.setArguments(bundle);
        return colorFragment;
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
