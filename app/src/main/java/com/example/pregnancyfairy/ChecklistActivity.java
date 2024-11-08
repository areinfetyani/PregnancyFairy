package com.example.pregnancyfairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChecklistActivity extends AppCompatActivity {
    TextView titleTxt;
    Button addBtn;
    Button backBtn;
    EditText edtTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checklist);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        titleTxt = findViewById(R.id.titleTxt);
        addBtn = findViewById(R.id.addBtn);
        backBtn = findViewById(R.id.backBtn);
        edtTxt = findViewById(R.id.edtTxt);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        titleTxt.setText(title.toString());

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edtTxt.getText().toString();
                if (!str.isEmpty()) {
                    edtTxt.setText("");
                    Toast.makeText(ChecklistActivity.this, "Request sent, waiting for approval. Thank you.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ChecklistActivity.this, "Checklist item cannot be empty. Please enter a description.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChecklistActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });
    }
}