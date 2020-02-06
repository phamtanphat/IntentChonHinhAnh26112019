package com.example.intentchonhinhanh26112019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

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
        for (int i = 0 ; i < sodong ; i++){
            TableRow tableRow = new TableRow(AnimalsActivity.this);
            for (int y = 0 ; y < socot ; y++){
                ImageView imageView = new ImageView(AnimalsActivity.this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(355,350);
                imageView.setLayoutParams(layoutParams);
                int valueHinhChon = getResources().getIdentifier(
                        arrayNamesAnimal[index++],
                        "drawable",
                        getPackageName());
                imageView.setImageResource(valueHinhChon);
                tableRow.addView(imageView);
            }
            mTableLayout.addView(tableRow);
        }

    }

    private void mapview() {
        mTableLayout = findViewById(R.id.tableLayout);
    }
}
