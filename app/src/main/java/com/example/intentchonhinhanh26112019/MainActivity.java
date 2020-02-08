package com.example.intentchonhinhanh26112019;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView mImgHinhGoc,mImgHinhChon;
    TextView mTvDiemSo;
    LinearLayout mLayoutLoading;
    String[] arrayNamesAnimal;
    int mIndexHinhGoc = -1;
    int mValueHinhGoc = -1;
    int mRequestCodeImage = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mapview();
        mapImageRandom();
        setListener();
    }

    private void setListener() {
        mImgHinhChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AnimalsActivity.class);
                startActivityForResult(intent,mRequestCodeImage);
            }
        });
    }

    private void init() {
        arrayNamesAnimal = getResources().getStringArray(R.array.arrayNamesAnimal);
    }

    private void mapview() {
        mImgHinhChon = findViewById(R.id.imageviewHinhchon);
        mImgHinhGoc = findViewById(R.id.imageviewHinhgoc);
        mTvDiemSo = findViewById(R.id.textviewdiem);
        mLayoutLoading = findViewById(R.id.linearLoading);
    }
    private void mapImageRandom() {
        mIndexHinhGoc = new Random().nextInt(arrayNamesAnimal.length);
        mValueHinhGoc = getResources().getIdentifier(
                arrayNamesAnimal[mIndexHinhGoc],
                "drawable",
                getPackageName());
        mImgHinhGoc.setImageResource(mValueHinhGoc);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 123 && resultCode == RESULT_OK && data != null){
            int idHinhChon = data.getIntExtra("idhinh",0);
            mImgHinhChon.setImageResource(idHinhChon);

            if (idHinhChon == mValueHinhGoc){
                Toast.makeText(this, "Chọn chính xác!!", Toast.LENGTH_SHORT).show();
                isLoading(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mapImageRandom();
                        mImgHinhChon.setImageResource(R.drawable.nophoto);
                        isLoading(false);
                    }
                },2000);

            }else{
                Toast.makeText(this, "Sai rồi!!", Toast.LENGTH_SHORT).show();
            }
        }
        if (resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Bạn chưa chọn con nào cả!!", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void isLoading(Boolean isload){
        if (isload) {
            mLayoutLoading.setVisibility(View.VISIBLE);
            mImgHinhChon.setEnabled(false);
        }else{
            mLayoutLoading.setVisibility(View.GONE);
            mImgHinhChon.setEnabled(true);
        }
    }

}
