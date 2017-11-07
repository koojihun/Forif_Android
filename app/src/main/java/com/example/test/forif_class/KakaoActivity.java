package com.example.test.forif_class;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Koo on 2017-10-10.
 */

public class KakaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao);

        ListView listView = (ListView) findViewById(R.id.listView);
        FriendAdapter friendAdapter = new FriendAdapter();

        listView.setAdapter(friendAdapter);

        friendAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_face_black_36dp), "호날두", "구지훈~ 축구하자");
        friendAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_face_black_36dp), "베일", "아~ 다리아파");
        friendAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_face_black_36dp), "이스코", "아~ 힘들어");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FriendItem item = (FriendItem) parent.getItemAtPosition(position);

                String status = item.getStatus();
                String name = item.getName();
                Drawable iconImg = item.getImg();

                System.out.println(name + "!!!!!!!!!!!!!!!");
            }
        });
    }
}
