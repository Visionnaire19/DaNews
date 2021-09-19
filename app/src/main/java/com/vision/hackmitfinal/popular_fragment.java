package com.vision.hackmitfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link popular_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class popular_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public List list = new ArrayList();

    public popular_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment popular_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static popular_fragment newInstance(String param1, String param2) {
        popular_fragment fragment = new popular_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list.add("Covid-19");
        list.add("College");
        list.add("Terrorism");
        list.add("Economic crisis");
        list.add("Sleep");
        list.add("Academics");
        list.add("Work-life balance");
        list.add("Music");
        list.add("LGBTQ+");
        list.add("France");
        list.add("Iphone 13");
        list.add("Sports");
        list.add("Finance");
        list.add("Beauty");
        list.add("Guns");


        ListView listView = view.findViewById(R.id.popular_list);
        listView.setAdapter(new PopularListAdapter(getContext(), list));



    }
}