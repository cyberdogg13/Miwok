package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColoursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_layout);

        ArrayList<Word> colours = new ArrayList<Word>();
        colours.add(new Word("red", "weṭeṭṭi", R.drawable.color_red));
        colours.add(new Word("green", "chokokki",R.drawable.color_green));
        colours.add(new Word("brown", "ṭakaakki",R.drawable.color_brown));
        colours.add(new Word("gray", "ṭopoppi",R.drawable.color_gray));
        colours.add(new Word("black", "kululli",R.drawable.color_black));
        colours.add(new Word("white", "kelelli",R.drawable.color_white));
        colours.add(new Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow));
        colours.add(new Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow));


        WordAdapter adapter = new WordAdapter(this, colours,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}