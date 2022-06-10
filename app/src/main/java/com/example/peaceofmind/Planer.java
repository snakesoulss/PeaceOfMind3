package com.example.peaceofmind;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;

import db.InputContract;
import db.InputDbHelper;

public class Planer extends AppCompatActivity {
    private SharedPreferences saveTasksFromToDoList;
    private EditText inputCases;
    private InputDbHelper mHelper;
    private ListView list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planer);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        inputCases = (EditText) findViewById(R.id.inputCase);
        list = (ListView) findViewById(R.id.taskList);
        mHelper = new InputDbHelper(this);
        updateUI();
    }


    private void updateUI() {
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(InputContract.TaskEntry.TABLE,
                new String[]{InputContract.TaskEntry._ID, InputContract.TaskEntry.COL_TASK_TITLE},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            int idx = cursor.getColumnIndex(InputContract.TaskEntry.COL_TASK_TITLE);
            taskList.add(cursor.getString(idx));
        }
        if (adapter == null) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,
                    taskList);
            list.setAdapter(adapter);
        } else {
            adapter.clear();
            adapter.addAll(taskList);
            adapter.notifyDataSetChanged();
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                AlertDialog.Builder num=new AlertDialog.Builder(Planer.this);
                num.setIcon(android.R.drawable.ic_delete);
                num.setTitle("Удалить?");
                num.setMessage("Вы уверены,что хотите удалить задачу?");
                final int positionToRemove = position;
                num.setNegativeButton("Cancel", null);
                num.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        taskList.remove(positionToRemove);
                        adapter.notifyDataSetChanged();
                    }});
                num.show();
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


    public void SaveTasks(View view) {
        String input = inputCases.getText().toString();
        SQLiteDatabase db = mHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InputContract.TaskEntry.COL_TASK_TITLE, input);
        db.insertWithOnConflict(InputContract.TaskEntry.TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
        updateUI();
    }
}