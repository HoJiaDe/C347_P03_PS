package com.example.c347_p03_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView tvWeek;
    RadioGroup rg;
    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvWeek = findViewById(R.id.tvWeek);
        btnSubmit = findViewById(R.id.btnSubmit);
        rg = findViewById(R.id.rgRadio);

        Intent i = getIntent();

        String week = i.getStringExtra("week");
        tvWeek.setText(week);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedBtnID = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedBtnID);
                final String grade = rb.getText().toString();

                //Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("grade", grade);
                // Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the
                setResult(RESULT_OK, i);
                finish();

            }
        });


    }
}
