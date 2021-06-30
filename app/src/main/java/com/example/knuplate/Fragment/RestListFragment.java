package com.example.knuplate.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.knuplate.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RestListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestListFragment extends Fragment {

    // TODO: Rename and change types of parameters

    RecyclerView completedList;
    private String category;
    private TextView textView;

    public RestListFragment(String category) {
        // Required empty public constructor
        this.category = category;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_rest_list, null);
        textView = (TextView)view.findViewById(R.id.frag_tv);
        textView.setText(category);

        // Inflate the layout for this fragment
        return view;
    }
}