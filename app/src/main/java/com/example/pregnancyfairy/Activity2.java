package com.example.pregnancyfairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {
    TextView titleTxt;
    ListView listView;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.list);
        titleTxt = findViewById(R.id.titleTxt);
        backBtn = findViewById(R.id.backBtn);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        titleTxt.setText(title.toString());

        if (title.equals("Health Tips")) {
            ArrayAdapter<Tip> listAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1,
                    Tip.tips);
            listView.setAdapter(listAdapter);

            AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent,
                                        View view,
                                        int position,
                                        long id) {
                    Intent intent = new Intent(Activity2.this,
                            DetailsActivity.class);
                    intent.putExtra("image", (int) id);
                    intent.putExtra("title", title);
                    startActivity(intent);

                }
            };
            listView.setOnItemClickListener(itemClickListener);
        } else if (title.equals("Exercises")) {
            titleTxt.setText(title.toString());
            ArrayAdapter<Exercise> listAdapter = new ArrayAdapter<Exercise>(this,
                    android.R.layout.simple_list_item_1,
                    Exercise.exercises);

            listView.setAdapter(listAdapter);

            AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent,
                                        View view,
                                        int position,
                                        long id) {
                    Intent intent = new Intent(Activity2.this,
                            DetailsActivity.class);
                    intent.putExtra("image", (int) id);
                    intent.putExtra("title", title);
                    startActivity(intent);
                }
            };
            listView.setOnItemClickListener(itemClickListener);
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
