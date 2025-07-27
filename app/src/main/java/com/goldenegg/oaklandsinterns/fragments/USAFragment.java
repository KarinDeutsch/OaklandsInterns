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
import com.goldenegg.oaklandsinterns.UsaOhioActivity;
import com.goldenegg.oaklandsinterns.basics.BasicLawsOhio;
import com.goldenegg.oaklandsinterns.basics.LawsRulesActivity;

public class USAFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_u_s_a, container, false);

        // Link views
        TextView population = view.findViewById(R.id.population);
        TextView name = view.findViewById(R.id.name);
        TextView language = view.findViewById(R.id.language);
        TextView capital = view.findViewById(R.id.capital);
        TextView government = view.findViewById(R.id.government);
        TextView funfact = view.findViewById(R.id.funfact);
        ImageView imageViewLogo = view.findViewById(R.id.oakland_logo);
        ImageView imageViewBack = view.findViewById(R.id.btnBack);

        // ✅ Logo button – go to MainActivity
        imageViewLogo.setOnClickListener(v ->
                startActivity(new Intent(requireActivity(), MainActivity.class))
        );

        // ✅ Back button – go to UsaOhioActivity
        imageViewBack.setOnClickListener(v ->
                startActivity(new Intent(requireActivity(), UsaOhioActivity.class))
        );

        // Set the text (if you’re using HTML tags)
        population.setText(Html.fromHtml("<b>Population:</b> 1.2 Mio."));
        name.setText(Html.fromHtml("<b>Official Name:</b> United States of America"));
        language.setText(Html.fromHtml("<b>Official Language:</b> English"));
        capital.setText(Html.fromHtml("<b>Capital City:</b> Washington D.C."));
        government.setText(Html.fromHtml("<b>Government:</b> Constitutional Republic"));

        return view;
    }
}