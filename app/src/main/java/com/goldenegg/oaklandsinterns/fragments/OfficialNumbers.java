package com.goldenegg.oaklandsinterns.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.goldenegg.oaklandsinterns.MainActivity;
import com.goldenegg.oaklandsinterns.R;

public class OfficialNumbers extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.fragment_official, container, false);

        // Correctly reference the ImageView
        ImageView imageView = view.findViewById(R.id.oakland_logo);

        // Set an OnClickListener
        if (imageView != null) {
            imageView.setOnClickListener(v -> {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            });
        }

        return view;
    }
}