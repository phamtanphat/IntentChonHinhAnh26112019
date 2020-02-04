package com.example.intentchonhinhanh26112019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView mImgHinhGoc,mImgHinhChon;
    TextView mTvDiemSo;
    String[] arrayNamesAnimal;
    int mIndexHinhGoc = -1;
    int mValueHinhGoc = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mapview();
        mapImageRandom();
    }

    private void init() {
        arrayNamesAnimal = getResources().getStringArray(R.array.arrayNamesAnimal);
    }

    private void mapview() {
        mImgHinhChon = findViewById(R.id.imageviewHinhchon);
        mImgHinhGoc = findViewById(R.id.imageviewHinhgoc);
        mTvDiemSo = findViewById(R.id.textviewdiem);
    }
    private void mapImageRandom() {
        mIndexHinhGoc = new Random().nextInt(arrayNamesAnimal.length);
        mValueHinhGoc = getResources().getIdentifier(
                arrayNamesAnimal[mIndexHinhGoc],
                "drawable",
                getPackageName());
        mImgHinhGoc.setImageResource(mValueHinhGoc);
    }
}
