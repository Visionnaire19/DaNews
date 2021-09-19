package com.vision.hackmitfinal;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ListView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.vision.hackmitfinal.databinding.ActivityDisplayBinding;

import java.util.ArrayList;

public class Display extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        ArrayList<Article> myList = (ArrayList<Article>) getIntent().getSerializableExtra("mylist");

        ListView ListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        articleAdapter adapter = new articleAdapter(this, myList);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        ListView.setAdapter(adapter);

    }
}