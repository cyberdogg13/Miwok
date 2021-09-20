package com.example.android.miwok;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

//        codeblock voor intent van numberactivity
        TextView numbers = (TextView) findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });
//          codeblock voor intent van coloursactivity
        TextView colours = (TextView) findViewById(R.id.colors);
        colours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent coloursIntent = new Intent(MainActivity.this, ColoursActivity.class);
                startActivity(coloursIntent);
            }
        });

        //          codeblock voor intent van Phrasessactivity
        TextView phrases = (TextView) findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, PrhasesActivity.class);
                startActivity(phrasesIntent);
            }
        });

        //          codeblock voor intent van familyMambersactivity
        TextView familyMembers = (TextView) findViewById(R.id.family);
        familyMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familymembersIntent = new Intent(MainActivity.this, FamilyMebersActivity.class);
                startActivity(familymembersIntent);
            }
        });


    }
}