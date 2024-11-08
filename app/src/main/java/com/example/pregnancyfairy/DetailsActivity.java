package com.example.pregnancyfairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailsActivity extends AppCompatActivity {
    ImageView image;
    TextView nameTxt;
    TextView descriptionTxt;
    Button backBtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        image = findViewById(R.id.image);
        nameTxt = findViewById(R.id.nameTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        backBtn2 = findViewById(R.id.backBtn2);

        Intent intent = getIntent();
        int id = (int)intent.getExtras().get("image");
        String title = intent.getStringExtra("title");


        if(title.equals("Health Tips")){
            Tip tip = Tip.tips[id];
            image.setImageResource(tip.getId());
            nameTxt.setText(tip.getTitle());
            descriptionTxt.setText(tip.getDescription());
        } else if(title.equals("Exercises")){
            Exercise exercise = Exercise.exercises[id];
            image.setImageResource(exercise.getId());
            nameTxt.setText(exercise.getTitle());
            descriptionTxt.setText(exercise.getDescription());
        }
        backBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this,
                        Activity2.class);
                startActivity(intent);
            }
        });
    }
}