package com.goldenegg.oaklandsinterns.basics;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.goldenegg.oaklandsinterns.BasicsActivity;
import com.goldenegg.oaklandsinterns.MainActivity;
import com.goldenegg.oaklandsinterns.R;

import java.util.HashMap;
import java.util.Map;

public class ConversionsActivity extends AppCompatActivity {

    private Spinner spinnerCategory, spinnerFromUnit, spinnerToUnit;
    private EditText editTextValue;
    private Button buttonConvert;
    private TextView textViewResult;

    // Conversion units for categories
    private Map<String, String[]> unitsMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversions);  // your XML filename


// Logo button – go to MainActivity
        ImageView imageViewLogo = findViewById(R.id.oakland_logo);
        imageViewLogo.setOnClickListener(v ->
                startActivity(new Intent(ConversionsActivity.this, MainActivity.class))
        );

        // Back button – go to BasicsActivity
        ImageView imageViewBack = findViewById(R.id.btnBack);
        imageViewBack.setOnClickListener(v ->
                startActivity(new Intent(ConversionsActivity.this, BasicsActivity.class))
        );

        // Find views
        spinnerCategory = findViewById(R.id.spinner_category);
        spinnerFromUnit = findViewById(R.id.spinner_from_unit);
        spinnerToUnit = findViewById(R.id.spinner_to_unit);
        editTextValue = findViewById(R.id.edittext_value);
        buttonConvert = findViewById(R.id.button_convert);
        textViewResult = findViewById(R.id.textview_result);

        // Setup units for each category
        unitsMap.put("Length", new String[]{"Meters", "Feet", "Inches", "Kilometers", "Miles"});
        unitsMap.put("Weight", new String[]{"Kilograms", "Pounds", "Ounces"});
        unitsMap.put("Volume", new String[]{"Liters", "Gallons", "Milliliters", "Cups"});

        // Setup Category spinner
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                unitsMap.keySet().toArray(new String[0]));
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);

        // When category changes, update units spinners
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String category = (String) parent.getItemAtPosition(position);
                updateUnitSpinners(category);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Setup Convert button click
        buttonConvert.setOnClickListener(v -> performConversion());

        // Initialize units spinner with first category
        if (categoryAdapter.getCount() > 0) {
            spinnerCategory.setSelection(0);
            updateUnitSpinners((String) spinnerCategory.getSelectedItem());
        }
    }

    private void updateUnitSpinners(String category) {
        String[] units = unitsMap.get(category);

        if (units == null) return;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFromUnit.setAdapter(adapter);
        spinnerToUnit.setAdapter(adapter);
    }

    private void performConversion() {
        String inputStr = editTextValue.getText().toString().trim();

        if (TextUtils.isEmpty(inputStr)) {
            Toast.makeText(this, "Please enter a value to convert", Toast.LENGTH_SHORT).show();
            return;
        }

        double inputValue;
        try {
            inputValue = Double.parseDouble(inputStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number format", Toast.LENGTH_SHORT).show();
            return;
        }

        String category = (String) spinnerCategory.getSelectedItem();
        String fromUnit = (String) spinnerFromUnit.getSelectedItem();
        String toUnit = (String) spinnerToUnit.getSelectedItem();

        // If fromUnit == toUnit, result = inputValue (no conversion)
        if (fromUnit.equals(toUnit)) {
            textViewResult.setText(String.format("%.4f %s", inputValue, toUnit));
            return;
        }

        // Convert inputValue from 'fromUnit' to a base unit, then to 'toUnit'
        double baseValue = convertToBaseUnit(category, fromUnit, inputValue);
        double convertedValue = convertFromBaseUnit(category, toUnit, baseValue);

        textViewResult.setText(String.format("%.4f %s", convertedValue, toUnit));
    }

    // Base units: Length = meters, Weight = kilograms, Volume = liters
    private double convertToBaseUnit(String category, String fromUnit, double value) {
        switch (category) {
            case "Length":
                switch (fromUnit) {
                    case "Meters": return value;
                    case "Feet": return value * 0.3048;
                    case "Inches": return value * 0.0254;
                    case "Kilometers": return value * 1000;
                    case "Miles": return value * 1609.344;
                }
                break;
            case "Weight":
                switch (fromUnit) {
                    case "Kilograms": return value;
                    case "Pounds": return value * 0.45359237;
                    case "Ounces": return value * 0.02834952;
                }
                break;
            case "Volume":
                switch (fromUnit) {
                    case "Liters": return value;
                    case "Gallons": return value * 3.78541;
                    case "Milliliters": return value * 0.001;
                    case "Cups": return value * 0.236588;
                }
                break;
        }
        return 0; // Fallback, unknown unit
    }

    private double convertFromBaseUnit(String category, String toUnit, double value) {
        switch (category) {
            case "Length":
                switch (toUnit) {
                    case "Meters": return value;
                    case "Feet": return value / 0.3048;
                    case "Inches": return value / 0.0254;
                    case "Kilometers": return value / 1000;
                    case "Miles": return value / 1609.344;
                }
                break;
            case "Weight":
                switch (toUnit) {
                    case "Kilograms": return value;
                    case "Pounds": return value / 0.45359237;
                    case "Ounces": return value / 0.02834952;
                }
                break;
            case "Volume":
                switch (toUnit) {
                    case "Liters": return value;
                    case "Gallons": return value / 3.78541;
                    case "Milliliters": return value / 0.001;
                    case "Cups": return value / 0.236588;
                }
                break;
        }
        return 0; // Fallback
    }
}
