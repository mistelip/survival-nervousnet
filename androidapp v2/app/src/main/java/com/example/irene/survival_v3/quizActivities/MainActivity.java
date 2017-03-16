package com.example.irene.survival_v3.quizActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.irene.survival_v3.MapActivity;
import com.example.irene.survival_v3.R;
import com.example.irene.survival_v3.SettingsActivity;
import com.example.irene.survival_v3.tipsActivities.TipsActivity;

public class MainActivity extends AppCompatActivity {

    //SwipeAdapter swipeAdapter;
    QuizPagerAdapter mCustomPagerAdapter;
    QuizViewPager mViewPager;
    private final QuizController quizController =  new QuizController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d("#MainActivity","Loaded quiz activity");
        mViewPager = (QuizViewPager) findViewById(R.id.myViewPager);
        mCustomPagerAdapter = new QuizPagerAdapter(getSupportFragmentManager(), quizController, mViewPager, this);
        mViewPager.setAdapter(mCustomPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                QuizFragmentInterface fragment = (QuizFragmentInterface) mCustomPagerAdapter.instantiateItem(mViewPager, position);
                if (fragment != null) {
                    fragment.fragmentBecameVisible();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //mViewPager = (CustomViewPager) findViewById(R.id.myViewPager);
        //swipeAdapter = new SwipeAdapter(getSupportFragmentManager(), quizController, mViewPager);
        //mViewPager.setAdapter(swipeAdapter);

        mViewPager.setPagingEnabled(true);

        // Swipe demo
        /*
        final Button basicNeeds_butt = (Button) findViewById(R.id.swipeViewButton);
        basicNeeds_butt.setOnClickListener(new View.OnClickListener() {
            //earthquake_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        */



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == R.id.action_map) {
            Intent intent = new Intent(MainActivity.this, MapActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
        if (id == R.id.action_tips) {
            Intent intent = new Intent(MainActivity.this, TipsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
