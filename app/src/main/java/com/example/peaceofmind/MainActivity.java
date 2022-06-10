package com.example.peaceofmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonOpenCard;
    Button buttonPlaner;
    Button buttonCard;
    ImageView imageViewCards;

    private List<Integer> mImageResources = new ArrayList<>();



    public List<Integer> getmImageResources(ImageView imageView) {
        return mImageResources;
    }

    public Drawable setmImageResources(List<Integer> mImageResources) {
        this.mImageResources = mImageResources;
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageResources.add(R.drawable.shut);
        mImageResources.add(R.drawable.mag);
        mImageResources.add(R.drawable.verhovayazhrica);
        mImageResources.add(R.drawable.imperatrica);
        mImageResources.add(R.drawable.imperator);
        mImageResources.add(R.drawable.verhovnyizhrec);
        mImageResources.add(R.drawable.vlublennye);
        mImageResources.add(R.drawable.kolesnica);
        mImageResources.add(R.drawable.sila);
        mImageResources.add(R.drawable.otshelnik);
        mImageResources.add(R.drawable.kolesofortuny);
        mImageResources.add(R.drawable.spravedlivost);
        mImageResources.add(R.drawable.poveshennyi);
        mImageResources.add(R.drawable.smert);
        mImageResources.add(R.drawable.umerennost);
        mImageResources.add(R.drawable.diyavol);
        mImageResources.add(R.drawable.padayushayabashnya);
        mImageResources.add(R.drawable.zvezda);
        mImageResources.add(R.drawable.luna);
        mImageResources.add(R.drawable.solnce);
        mImageResources.add(R.drawable.strashnyisud);
        mImageResources.add(R.drawable.mir);

        imageViewCards = (ImageView) findViewById(R.id.imageView);
        buttonCard = (Button) findViewById(R.id.meditationsButton);
        buttonOpenCard = (Button) findViewById(R.id.btnOpenCard);
        buttonPlaner = (Button) findViewById(R.id.button_planer);
        buttonOpenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
//            public void OpenCardDay (View view) {
//                imageViewCards = (ImageView) findViewById(R.id.imageView);
//                imageViewCards.setImageDrawable(setmImageResources(mImageResources));
//                setContentView(imageViewCards);
//            }
        });
    }

    public void toPlaner (View view){
        Intent intent = new Intent(this,Planer.class);
        startActivity(intent);
    }


    public void toMeditations (View view){
        Intent intent = new Intent(this,Meditations.class );
        startActivity(intent);
    }


    public void toStudy (View view){
        Intent intent = new Intent(this,Study.class);
        startActivity(intent);
    }


    public void OpenCardDay(View view) {
        imageViewCards = (ImageView) findViewById(R.id.imageView);
        imageViewCards.setImageResource(R.drawable.mag);
        imageViewCards.setImageResource(R.drawable.shut);
        imageViewCards.setImageResource(R.drawable.verhovayazhrica);
        imageViewCards.setImageResource(R.drawable.imperatrica);
        imageViewCards.setImageResource(R.drawable.imperator);
        imageViewCards.setImageResource(R.drawable.verhovnyizhrec);
        imageViewCards.setImageResource(R.drawable.vlublennye);
        imageViewCards.setImageResource(R.drawable.kolesnica);
        imageViewCards.setImageResource(R.drawable.otshelnik);
        imageViewCards.setImageResource(R.drawable.kolesofortuny);
        imageViewCards.setImageResource(R.drawable.spravedlivost);
        imageViewCards.setImageResource(R.drawable.poveshennyi);
        imageViewCards.setImageResource(R.drawable.umerennost);
        imageViewCards.setImageResource(R.drawable.diyavol);
        imageViewCards.setImageResource(R.drawable.padayushayabashnya);
        imageViewCards.setImageResource(R.drawable.solnce);
        imageViewCards.setImageResource(R.drawable.strashnyisud);
        imageViewCards.setImageResource(R.drawable.mir);
    }
}
