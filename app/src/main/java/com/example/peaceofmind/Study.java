package com.example.peaceofmind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Study extends AppCompatActivity {
    private ListView studyInf;
    private String number;
    String[] url = {"https://asana.com/ru/resources/pomodoro-technique","https://semyadeti.ru/kak-poborot-len-i-nachat-uchitsya.htm1",
    "https://fb.ru/article/316144/zachem-nujno-uchitsya-dlya-chego-myi-uchimsya","https://strana-sovetov.com/kids/14/1748-teenager-classmates.html" +
            "https://lifehacker.ru/23-hacks-for-studying/"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        studyInf = (ListView) findViewById(R.id.information);
       studyInf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent i = new Intent(Intent.ACTION_VIEW);
               i.setData(Uri.parse(String.valueOf(url)));
               startActivity(i);
           }
       });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}