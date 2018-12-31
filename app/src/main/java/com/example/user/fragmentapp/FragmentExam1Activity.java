package com.example.user.fragmentapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FragmentExam1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_exam1);
    }

    private void addFragment(int containerId,int color,String text){
        TextFragment textFragment = new TextFragment();
        textFragment.setColor(color);
        getSupportFragmentManager().beginTransaction().add(containerId,textFragment)
                .commit();
        textFragment.setText(text);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                addFragment(R.id.container_1,Color.RED,"1번프래그먼트");
                break;
            case R.id.button2:
                addFragment(R.id.container_2,Color.BLUE,"2번프래그먼트");
                break;
            case R.id.button3:
                addFragment(R.id.container_3,Color.YELLOW,"3번프래그먼트");
                break;
        }
    }
}
