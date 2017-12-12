package com.kadek.tripguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextMessage;
    ViewPager viewPager;
    PagerAdaptor adapter;

    private String[] images = {

            "http://www.travelfoodfashion.com/wp-content/uploads/2014/05/Karimun-Jawa-Beach.jpg",
            "http://planetescape.eu/uploaded/foto/1407171652464517968.jpg/1407171652464517968.jpg",
            "http://bsnscb.com/data/out/102/27259885-indonesia-wallpapers.jpeg",
            "http://awesomwallpaper.com/img1/3A9DF9E06BEA/indonesia-beaches.jpg" };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        adapter = new PagerAdaptor(MainActivity.this,images);
        viewPager.setAdapter(adapter);
        onClick();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    public void onClick(){
        Button but1 = (Button) findViewById(R.id.button1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, ScrollingActivity.class);
                startActivity(a);
            }
        });
    }

}
