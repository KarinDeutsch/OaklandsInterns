package com.goldenegg.oaklandsinterns.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.goldenegg.oaklandsinterns.MainActivity;
import com.goldenegg.oaklandsinterns.R;

public class OhioFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.fragment_ohio, container, false);

        // Link TextViews to their IDs in the XML layout
        TextView population = view.findViewById(R.id.population);
        TextView name = view.findViewById(R.id.name);
        TextView language = view.findViewById(R.id.language);
        TextView capital = view.findViewById(R.id.capital);
        TextView government = view.findViewById(R.id.government);
        TextView area = view.findViewById(R.id.area);


        // Set the text with HTML formatting for bold labels
        population.setText(Html.fromHtml("<b>Population:</b> 11.8 Mio., ranking 7th in USA."));
        name.setText(Html.fromHtml("<b>Official Name:</b> Ohio aka The Buckeye State"));
        language.setText(Html.fromHtml("<b>Nickname:</b> Birthplace of Aviation, The Heart of It All"));
        capital.setText(Html.fromHtml("<b>Capital City:</b> Columbus"));
        government.setText(Html.fromHtml("<b>Government:</b> Executive (Governor), Legislative (General Assembly), Judicial (Supreme Court)"));
        area.setText(Html.fromHtml("<b>Area:</b> 116,096 sq km (44,825 sq miles) ranking 34th in USA"));

        // Fix the ImageView click listener
        ImageView imageView = view.findViewById(R.id.oakland_logo);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
