package com.vision.hackmitfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PopularListAdapter extends ArrayAdapter {
    private final Context context;
    private final List<String> values;

    public PopularListAdapter(@NonNull Context context, List values) {
     super(context, -1, values);
     this.context = context;
     this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        RecyclerView.ViewHolder holder;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_row, parent, false);

        TextView text1 = rowView.findViewById(R.id.popular_1);
        TextView text2 = rowView.findViewById(R.id.popular_2);
        TextView text3 = rowView.findViewById(R.id.popular_3);

        assert position < values.size()-1;
        text1.setText(values.get(position));
        text2.setText(values.get(position + 1));
        text3.setText(values.get(position + 2));

        return rowView;
    }
}
