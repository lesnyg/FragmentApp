package com.lesnyg.user.fragmentapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends ColorFragment {

    private String mText = "";
    private TextView mTextView;

    public TextFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mTextView = (TextView)view.findViewById(R.id.text_text);
        mTextView.setText(mText);
        return view;
    }

    public void setText(String text){
        mText = text;

        if(getView() != null){
            mTextView.setText(mText);
        }
    }
}
