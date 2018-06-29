package com.djdenn.myapplication;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listItems;
    EditText edtEntry;
    Button btnSubmit;
    ListAdapter listAdapter;
    List<String> dataBank;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listItems = (ListView) findViewById(R.id.listItems);
        edtEntry = (EditText) findViewById(R.id.edtEntry);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        dataBank = new ArrayList<>();
        myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataBank);
        listItems.setAdapter(myAdapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(edtEntry.getText().toString())){
                    myAdapter.add(edtEntry.getText().toString());
                    myAdapter.notifyDataSetChanged();
                }
            }
        });

        listItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                myAdapter.remove(myAdapter.getItem(position));
                myAdapter.notifyDataSetChanged();
                return false;
            }
        });

    }



}
