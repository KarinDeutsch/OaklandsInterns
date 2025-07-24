package com.goldenegg.oaklandsinterns.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenegg.oaklandsinterns.R;
import com.goldenegg.oaklandsinterns.adapters.LocalNumberAdapter;
import com.goldenegg.oaklandsinterns.models.LocalNumberItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalNumbers extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner spinner1;
    private RecyclerView recyclerView;
    private LocalNumberAdapter adapter;
    private List<LocalNumberItem> fullList;

    private static final String[] locations = {"Columbus", "Delaware", "Dublin", "New Albany"};

    public LocalNumbers() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_local_numbers, container, false);

        spinner1 = view.findViewById(R.id.spinner1);
        recyclerView = view.findViewById(R.id.cardRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Initialize the full list of local numbers
        fullList = Arrays.asList(
                new LocalNumberItem("Hospital", "OhioHealth Riverside Methodist Hospital", "3535 Olentangy River Rd, Columbus, 43214", "614-566-5000", R.drawable.ic_hospital, "Columbus"),
                new LocalNumberItem("Urgent Care", "Hometown Urgent Care & Occupational Health", "1615 Morse Rd, Columbus, 43229", "614-681-1100", R.drawable.ic_urgent, "Columbus"),
                new LocalNumberItem("Doctor", "Dr. Doran William R DO", "1043 E Weber Rd, Columbus, 43211", "614-268-1701", R.drawable.ic_doctor, "Columbus"),
                new LocalNumberItem("Pharmacy", "CVS Pharmacy", "3100 Cleveland Ave, Columbus, 43224", "614-263-0923", R.drawable.ic_pharmacy, "Columbus"),
                new LocalNumberItem("Dentist", "Shiflett Family Dental", "3805 N High St #207, Columbus, 43214", "614-262-1807", R.drawable.ic_tooth, "Columbus"),
                new LocalNumberItem("Location", "Oakland Nursery Columbus", "1156 Oakland Park Ave, Columbus, 43224", "614-268-3511", R.drawable.ic_launcher_web, "Columbus"),

                new LocalNumberItem("Hospital", "OhioHealth Grady Memorial Hospital", "561 W Central Ave, Delaware", "740-615-1000", R.drawable.ic_hospital, "Delaware"),
                new LocalNumberItem("Urgent Care", "Delaware County EMS", "10 Court St, Delaware", "740-833-2190", R.drawable.ic_urgent, "Delaware"),
                new LocalNumberItem("Doctor", "Dr. Office Delaware", "90 E William St, Delaware", "740-362-8686", R.drawable.ic_doctor, "Delaware"),
                new LocalNumberItem("Pharmacy", "Meijer Pharmacy", "1380 Sunbury Rd, Delaware", "740-368-5910", R.drawable.ic_pharmacy, "Delaware"),
                new LocalNumberItem("Dentist", "Delaware Smile Center", "1012 State Rte 521 Ste 202, Delaware", "740-417-9565", R.drawable.ic_tooth, "Delaware"),
                new LocalNumberItem("Location", "Oakland Nursery Delaware", "25 Killbourne Rd, Delaware", "740-369-5454", R.drawable.ic_launcher_web, "Delaware"),

                new LocalNumberItem("Hospital", "OhioHealth Rehabilitation Hospital", "3805 Emerald Pkwy, Dublin, 43016", "614-665-9844", R.drawable.ic_hospital, "Dublin"),
                new LocalNumberItem("Urgent Care", "Minute Clinic at CVS", "7470 Sawmill Rd, Dublin, 43016", "866-389-2727", R.drawable.ic_urgent, "Dublin"),
                new LocalNumberItem("Doctor", "OhioHealth Physician Group Primary Care", "250 W Bridge St Ste 200, Dublin, 43017", "614-761-2244", R.drawable.ic_doctor, "Dublin"),
                new LocalNumberItem("Pharmacy", "Meijer Pharmacy", "6175 Sawmill Rd, Dublin, 43017", "614-718-5710", R.drawable.ic_pharmacy, "Dublin"),
                new LocalNumberItem("Dentist", "River Park Dental and Esthetics", "6605 Longshore St #220, Dublin, 43017", "380-888-2283", R.drawable.ic_tooth, "Dublin"),
                new LocalNumberItem("Location", "Oakland Nursery Dublin", "4261 W Granville Rd, Dublin, 43017", "614-874-2400", R.drawable.ic_launcher_web, "Dublin"),

                new LocalNumberItem("Hospital", "OhioHealth Emergency Care New Albany", "5868 N Hamilton Rd, New Albany, 43230", "614-788-9350", R.drawable.ic_hospital, "New Albany"),
                new LocalNumberItem("Doctor", "OhioHealth Spencer Scott Conte, DO", "5150 E Dublin Granville Rd, Suite 210, 43081", "614-788-9370", R.drawable.ic_doctor, "New Albany"),
                new LocalNumberItem("Urgent Care", "Mount Carmel Medical Group New Albany", "55 N High St, New Albany, 43054", "614-627-1878", R.drawable.ic_urgent, "New Albany"),
                new LocalNumberItem("Pharmacy", "Walgreens Pharmacy", "5195 N Hamilton Rd, 43230", "614-476-0988", R.drawable.ic_pharmacy, "New Albany"),
                new LocalNumberItem("Dentist", "Pure Dental Dawn C. Baker, DDS", "5175 More Rd Ste 200, Gahanna, 43230", "unspecified", R.drawable.ic_tooth, "New Albany"),
                new LocalNumberItem("Location", "Oakland Nursery New Albany", "5211 Johnstown Rd, New Albany, 43054", "614-917-1020", R.drawable.ic_launcher_web, "New Albany")
        );

        adapter = new LocalNumberAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, locations);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(spinnerAdapter);
        spinner1.setOnItemSelectedListener(this);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedLocation = locations[position];
        List<LocalNumberItem> filteredList = new ArrayList<>();

        for (LocalNumberItem item : fullList) {
            if (item.getCity().equalsIgnoreCase(selectedLocation)) {
                filteredList.add(item);
            }
        }

        adapter.updateData(filteredList);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}