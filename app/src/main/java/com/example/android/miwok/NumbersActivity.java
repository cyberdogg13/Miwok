package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_layout);

        ArrayList<Word> numbers = new ArrayList<Word>();
        numbers.add(new Word("one", "lutti"));
        numbers.add(new Word("two", "otiikko"));
        numbers.add(new Word("three", "tolookosu"));
        numbers.add(new Word("four", "oyyisa"));
        numbers.add(new Word("five", "massoka"));
        numbers.add(new Word("six", "temmokka"));
        numbers.add(new Word("seven", "kenekaku"));
        numbers.add(new Word("eight", "kawinta"));
        numbers.add(new Word("nine", "wo'e"));
        numbers.add(new Word("ten", "na'aacha"));

        WordAdapter adapter = new WordAdapter(this, numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }


}
