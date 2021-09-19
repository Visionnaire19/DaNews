package com.vision.hackmitfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int currentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }

        String data = "[{'title': \"New Colorado Climate Corps To 'Tackle The Climate Crisis'\", 'date': '2021-09-12 11:33:57', 'link': 'https://denver.cbslocal.com/2021/09/12/colorado-climate-corps-crisis/', 'clean_url': 'cbslocal.com', 'topic': 'news', 'tone': [['Joy', 0.698958]]}, {'title': \"Climate change: UN warning over nations' climate plans\", 'date': '2021-09-17 15:34:54', 'link': 'https://ca.finance.yahoo.com/news/climate-change-un-warning-over-152324055.html', 'clean_url': 'yahoo.com', 'topic': 'news', 'tone': [['Sadness', 0.506982], ['Confident', 0.648781], ['Analytical', 0.715861]]}, {'title': \"Climate change: UN warning over nations' climate plans\", 'date': '2021-09-17 15:21:30', 'link': 'https://www.bbc.com/news/science-environment-58600723', 'clean_url': 'bbc.com', 'topic': 'news', 'tone': [['Confident', 0.652364]]}, {'title': \"Climate change: UN warning over nations' climate plans\", 'date': '2021-09-17 15:21:30', 'link': 'https://www.bbc.co.uk/news/science-environment-58600723', 'clean_url': 'bbc.co.uk', 'topic': 'news', 'tone': [['Confident', 0.652364]]}, {'title': \"Don't miss: The Climate Coup looks at the finance of climate change\", 'date': '2021-09-16 18:15:00', 'link': 'https://www.newscientist.com/article/mg25133520-600-dont-miss-the-climate-coup-looks-at-the-finance-of-climate-change/', 'clean_url': 'newscientist.com', 'topic': 'news', 'tone': [['Joy', 0.761082]]}, {'title': \"Climate change: UN warning over nations' climate plans\", 'date': '2021-09-17 15:21:30', 'link': 'https://news.google.com/__i/rss/rd/articles/CBMiN2h0dHBzOi8vd3d3LmJiYy5jby51ay9uZXdzL3NjaWVuY2UtZW52aXJvbm1lbnQtNTg2MDA3MjPSATtodHRwczovL3d3dy5iYmMuY28udWsvbmV3cy9zY2llbmNlLWVudmlyb25tZW50LTU4NjAwNzIzLmFtcA?oc=5', 'clean_url': 'google.com', 'topic': 'news', 'tone': [['Sadness', 0.734158], ['Analytical', 0.743104]]}, {'title': 'Climate Bridge Conference', 'date': '2021-09-18 08:15:00', 'link': 'https://www.rutgers.edu/event/climate-bridge-conference', 'clean_url': 'rutgers.edu', 'topic': 'news', 'tone': [['Joy', 0.545705]]}, {'title': 'Forests and climate change', 'date': '2021-09-16 00:12:00', 'link': 'https://www.irishtimes.com/opinion/letters/forests-and-climate-change-1.4674812', 'clean_url': 'irishtimes.com', 'topic': 'news', 'tone': [['Confident', 0.6633], ['Analytical', 0.696569]]}, {'title': 'Connecting People With Credible Climate Change Information', 'date': '2021-09-16 11:00:40', 'link': 'https://about.fb.com/news/2021/09/tackling-climate-change-together/', 'clean_url': 'fb.com', 'topic': 'news', 'tone': [['Sadness', 0.618196], ['Tentative', 0.586281], ['Analytical', 0.530505]]}, {'title': 'New climate migration modelling puts a human face on climate impacts', 'date': '2021-09-15 11:25:54', 'link': 'https://phys.org/news/2021-09-climate-migration-human-impacts.html', 'clean_url': 'phys.org', 'topic': 'news', 'tone': [['Joy', 0.728412]]}, {'title': 'Climate change in india', 'date': '2021-09-18 11:27:29', 'link': 'https://www.slideshare.net/SapnaSharma996109/climate-change-in-india-250230393', 'clean_url': 'slideshare.net', 'topic': 'news', 'tone': [['Tentative', 0.55554]]}, {'title': 'Transport and climate change', 'date': '2021-09-16 23:04:00', 'link': 'https://www.irishtimes.com/opinion/letters/transport-and-climate-change-1.4676066', 'clean_url': 'irishtimes.com', 'topic': 'news', 'tone': [['Tentative', 0.789226], ['Analytical', 0.846505]]}, {'title': 'India-US launch Climate Action and Finance Mobilization Dialogue of Agenda 2030 Partnership', 'date': '2021-09-13 11:10:05', 'link': 'https://sg.news.yahoo.com/india-us-launch-climate-action-111005190.html', 'clean_url': 'yahoo.com', 'topic': 'politics', 'tone': [['Joy', 0.502623]]}, {'title': \"As New York And Louisiana Recover From Ida, Here's How You Can Help\", 'date': '2021-09-12 04:38:00', 'link': 'https://www.forbes.com/sites/bhaktimirchandani/2021/09/12/as-new-york-and-louisiana-recover-from-ida-heres-how-you-can-help/', 'clean_url': 'forbes.com', 'topic': 'business', 'tone': [['Sadness', 0.615801], ['Analytical', 0.757151]]}";




        Fragment search = new search_fragment();
        Fragment popular = new popular_fragment();


        BottomNavigationView bottomNavigationView = findViewById(R.id.main_page_bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(
                new NavigationBarView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.search_fragment:
                                replaceFragment(search);
                                currentFragment = 0;
                                return true;
                            case R.id.popular:
                                replaceFragment(popular);
                                currentFragment = 1;
                                return true;
                        }

                        return false;
                    }
                });
        replaceFragment(search);
        currentFragment = 0;

    }

    public void replaceFragment(Fragment Fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_page, Fragment); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }
   /* public void jean(String data){


        for (int i =0; i< results.size(); i++){

            hashMap.put(i, results.get(i));
        }

        for (Object value : hashMap.values()){
            String values = value.toString();
            String[] split = values.split("\\,");
            List fin_split = split.split("\\:");
            HashMap<String, String> f = new HashMap<>();
            f.put("title")
        }

        for(int i=0; i<results.size(); i++){


        }


    }

    */

}