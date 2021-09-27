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
        colours.add(new Word("red", "weṭeṭṭi"));
        colours.add(new Word("green", "chokokki"));
        colours.add(new Word("brown", "ṭakaakki"));
        colours.add(new Word("gray", "ṭopoppi"));
        colours.add(new Word("black", "kululli"));
        colours.add(new Word("white", "kelelli"));
        colours.add(new Word("dusty yellow", "ṭopiisә"));
        colours.add(new Word("mustard yellow", "chiwiiṭә"));


        WordAdapter adapter = new WordAdapter(this, colours);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}