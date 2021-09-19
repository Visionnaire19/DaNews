package com.vision.hackmitfinal;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class articleAdapter extends ArrayAdapter<Article> {

    public articleAdapter(Activity context, ArrayList<Article> articles) {
        super(context,0, articles);
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listViewItem = convertView;

        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.single_article, parent, false);

        }

        Article earthquake = getItem(position);

        TextView title = listViewItem.findViewById(R.id.title);
        title.setText(earthquake.title);


        return listViewItem;
    }
}


