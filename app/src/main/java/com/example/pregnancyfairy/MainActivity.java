package com.example.pregnancyfairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    String title;
    Spinner options;
    Button showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        options = findViewById(R.id.options);
        showBtn = findViewById(R.id.showBtn);
        bindSpinner();
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = options.getSelectedItem().toString();
                if (str.equals("Health Tips") || str.equals("Exercises")) {
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    title = str;
                    intent.putExtra("title", title);
                    startActivity(intent);
                }
                else if(str.equals("Hospital Checklist")){
                    Intent intent = new Intent(MainActivity.this, ChecklistActivity.class);
                    title = str;
                    intent.putExtra("title", title);
                    startActivity(intent);
                }
            }
        });

    }

    private void bindSpinner() {
        String[] arr = {"Select an Option", "Health Tips", "Exercises", "Hospital Checklist"};
        ArrayAdapter<String> spnAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        options.setAdapter(spnAdapter);
    }
}