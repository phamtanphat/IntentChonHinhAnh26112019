package com.example.intentchonhinhanh26112019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class AnimalsActivity extends AppCompatActivity {

    TableLayout mTableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        mapview();
        drawTableImage();
    }

    private void drawTableImage() {
        int socot = 3;
        int sodong = 6;
        for (int i = 0 ; i < sodong ; i++){
            TableRow tableRow = new TableRow(AnimalsActivity.this);
            for (int y = 0 ; y < socot ; y++){
                ImageView imageView = new ImageView(AnimalsActivity.this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(355,350);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageResource(R.drawable.bo);
                tableRow.addView(imageView);
            }
            mTableLayout.addView(tableRow);
        }

    }

    private void mapview() {
        mTableLayout = findViewById(R.id.tableLayout);
    }
}
