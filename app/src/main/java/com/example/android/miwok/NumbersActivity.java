package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    MediaPlayer player = new MediaPlayer();
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_layout);

        ArrayList<Word> numbers = new ArrayList<Word>();
        numbers.add(new Word("one", "lutti",R.drawable.number_one));
        numbers.add(new Word("two", "otiikko",R.drawable.number_two));
        numbers.add(new Word("three", "tolookosu",R.drawable.number_three));
        numbers.add(new Word("four", "oyyisa", R.drawable.number_four));
        numbers.add(new Word("five", "massoka", R.drawable.number_five));
        numbers.add(new Word("six", "temmokka", R.drawable.number_six));
        numbers.add(new Word("seven", "kenekaku", R.drawable.number_seven));
        numbers.add(new Word("eight", "kawinta", R.drawable.number_eight));
        numbers.add(new Word("nine", "wo'e", R.drawable.number_nine));
        numbers.add(new Word("ten", "na'aacha", R.drawable.number_ten));

        WordAdapter adapter = new WordAdapter(this, numbers, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                player = MediaPlayer.create(NumbersActivity.this, R.raw.number_one);
                player.start();
            }
        });


    }


}
