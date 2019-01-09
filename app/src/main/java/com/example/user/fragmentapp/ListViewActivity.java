package com.example.user.fragmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    private ListView mlistView;
    private ArrayList<Map<String,Object>> mDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mlistView = findViewById(R.id.list_view);

        mDataList = new ArrayList<>();
        addItem("프래그먼트 연습", "프래그먼트 연습1", FragmentExam1Activity.class);
        addItem("프래그먼트 콜백 연습", "콜백", ImageFragmentActivity.class);
        addItem("ViewPager", "", ViewPagerActivity.class);
        addItem("ViewPager 연습", "TabLayout,ViewPager", ViewPagerExamActivity.class);

        MyAdapter adapter = new MyAdapter(mDataList);

        mlistView.setAdapter(adapter);

        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
                Intent intent = (Intent) map.get("intent");
                startActivity(intent);
            }
        });
    }

    private void addItem(String title, String desc, Class cls) {
        Map<String,Object> map = new HashMap<>();
        map.put("title",title);
        map.put("desc",desc);
        map.put("intent",new Intent(this,cls));
        mDataList.add(map);
    }

    private static class MyAdapter extends BaseAdapter{

        private final List<Map<String,Object>> mData;

        public MyAdapter(List<Map<String, Object>> data) {
            mData = data;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2
                        ,parent,false);
            }
            TextView text1 = (TextView)convertView.findViewById(android.R.id.text1);
            TextView text2 = (TextView)convertView.findViewById(android.R.id.text2);

            Map<String,Object> item = mData.get(position);
            text1.setText((String)item.get("title"));
            text2.setText((String)item.get("desc"));
            return convertView;
        }
    }


}
