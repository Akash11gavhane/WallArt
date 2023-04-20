package com.example.wallart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    private Button aboutus;
    private Button feedback;
    private Button rate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        aboutus = (Button)findViewById(R.id.about_us_button);
        feedback = (Button)findViewById(R.id.feedback_button);
        rate=(Button)findViewById(R.id.rate_button);

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Settings.this, FeedBack.class);
                startActivity(intent);

            }
        });


        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Settings.this, rate.class);
                startActivity(intent2);
            }
        });



        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Settings.this, "Members :\n1132220253 Akash Gavhane\n1132220630 Juber Pansare\n1132220956 Saurabh Vaidya\n1132220659 Maaz Adhoni", Toast.LENGTH_LONG).show();
            }
        });



    }

    public void clickexit(View v){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }


}