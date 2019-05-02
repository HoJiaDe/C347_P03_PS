package com.example.c347_p03_ps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    //indicate get status back from the second activity
    int requestCode = 1;

    ListView lvDailyGrade;
    TextView tvWeek;
    TextView tvGrade;
    ArrayAdapter aaDailyGrade;
    ArrayList<DailyGrade> alDailyGrade;

    Button btnInfo;
    Button btnEmail;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvWeek = findViewById(R.id.tvWeek);
        tvGrade = findViewById(R.id.tvGrade);
        lvDailyGrade = findViewById(R.id.lvDailyGrade);

        btnEmail = findViewById(R.id.btnEmail);
        btnInfo = findViewById(R.id.btnInfo);
        btnAdd = findViewById(R.id.btnAdd);

        alDailyGrade = new ArrayList<DailyGrade>();

        alDailyGrade.add(new DailyGrade("Week 1", "B"));
        alDailyGrade.add(new DailyGrade("Week 2", "C"));
        alDailyGrade.add(new DailyGrade("Week 3", "A"));

        aaDailyGrade = new DailyGradeAdapter(this, R.layout.row, alDailyGrade);
        lvDailyGrade.setAdapter(aaDailyGrade);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "");
                email.putExtra(Intent.EXTRA_TEXT,
                        "");
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer num = alDailyGrade.size() + 1;
                String week = "Week " + num.toString();

                Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                i.putExtra("week", week);
                startActivityForResult(i, requestCode);

            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            Integer num = alDailyGrade.size() + 1;

            // Only handle when 2nd activity closed normally
            // and data contains something
            if(resultCode == RESULT_OK){
                if (data != null) {
                    // Get data passed back from 2nd activity
                    String grade = data.getStringExtra("grade");
                    alDailyGrade.add(new DailyGrade("Week " + num.toString(), grade));

                    aaDailyGrade.notifyDataSetChanged();

            }
        }


    }
}
