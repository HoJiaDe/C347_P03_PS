package com.example.c347_p03_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModule;
    ArrayList<String> alModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModule = this.findViewById(R.id.lvModule);

        alModule = new ArrayList<String>();
        alModule.add("C347");

        ArrayAdapter<String> aaModule;
        aaModule = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alModule);

        lvModule.setAdapter(aaModule);

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String module = alModule.get(position);

                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("module",module);

                startActivity(i);
            }
        });
    }
}
