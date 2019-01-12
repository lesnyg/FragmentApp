package com.lesnyg.user.fragmentapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ColorFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_fragment);

        //XML에서 프레그먼트 가져오기
        ColorFragment colorFragment = (ColorFragment)getSupportFragmentManager().findFragmentById(R.id.color_frag);
        colorFragment.setColor(Color.BLUE);

        //동적으로 프래그먼트 추가
        ColorFragment colorFragment2 = new ColorFragment();

//        팩토리 패턴을 활용한 프래그먼트 생성
//        ColorFragment colorFragment3 = ColorFragment.newInstance(Color.YELLOW);

        getSupportFragmentManager().beginTransaction().add(R.id.container,colorFragment2)
                .commit();
    }

    public void onClick(View view) {
        ColorFragment newColorFragment = new ColorFragment();
        int color = Color.YELLOW;
        //기존의 프래그먼트를 교체
        getSupportFragmentManager().beginTransaction().replace(R.id.container,newColorFragment)
                .commit();
        newColorFragment.setColor(color);
    }
}
