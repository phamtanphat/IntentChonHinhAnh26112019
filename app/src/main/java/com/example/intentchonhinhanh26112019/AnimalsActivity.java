package com.example.intentchonhinhanh26112019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class AnimalsActivity extends AppCompatActivity {

    TableLayout mTableLayout;
    String[] arrayNamesAnimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        init();
        mapview();
        drawTableImage();
    }

    private void init() {
        arrayNamesAnimal = getResources().getStringArray(R.array.arrayNamesAnimal);
    }

    private void drawTableImage() {
        int socot = 3;
        int sodong = 6;
        int index = 0;
        int valueHinhChon = 0;
        for (int i = 0 ; i < sodong ; i++){
            TableRow tableRow = new TableRow(AnimalsActivity.this);
            for (int y = 0 ; y < socot ; y++){
                final ImageView imageView = new ImageView(AnimalsActivity.this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(355,350);
                imageView.setLayoutParams(layoutParams);
                valueHinhChon = getResources().getIdentifier(
                        arrayNamesAnimal[index++],
                        "drawable",
                        getPackageName());
                imageView.setImageResource(valueHinhChon);
                imageView.setTag(valueHinhChon);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(AnimalsActivity.this, imageView.getTag().toString() + "", Toast.LENGTH_SHORT).show();
                    }
                });
                tableRow.addView(imageView);
            }
            mTableLayout.addView(tableRow);
        }

    }

    private void mapview() {
        mTableLayout = findViewById(R.id.tableLayout);
    }
}
