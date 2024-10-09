package com.example.lab1_ehe79041;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spinner = findViewById(R.id.spinner);
        final TextView txtOutput = findViewById(R.id.txtDisplay);
        String[] dropDownItems = getResources().getStringArray(R.array.spnDropdown);
        final String[] dropDownValues ={"Eranda Hettiarachchillage",
                                        "300379041",
                                        "This was the lab where I obtained some valuable experience while working on the calculator project. " +
                                                "I had followed the YouTube tutorial to build it and had few problems in the course. " +
                                                "I was still able to sort them out successfully and finish the project. In general, " +
                                                "it gave me opportunities to find out some interesting features and enhance my development."};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dropDownItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = dropDownValues[position];
                txtOutput.setText(value);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final Button button = findViewById(R.id.btnGotoCal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Calculator.class);
                startActivity(intent);
            }
        });



    }
}