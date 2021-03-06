package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColoursActivity extends AppCompatActivity {
    MediaPlayer player = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_layout);

        final ArrayList<Word> colours = new ArrayList<Word>();
        colours.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        colours.add(new Word("green", "chokokki",R.drawable.color_green, R.raw.color_green));
        colours.add(new Word("brown", "ṭakaakki",R.drawable.color_brown, R.raw.color_brown));
        colours.add(new Word("gray", "ṭopoppi",R.drawable.color_gray, R.raw.color_gray));
        colours.add(new Word("black", "kululli",R.drawable.color_black, R.raw.color_black));
        colours.add(new Word("white", "kelelli",R.drawable.color_white, R.raw.color_white));
        colours.add(new Word("dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colours.add(new Word("mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));


        WordAdapter adapter = new WordAdapter(this, colours,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = colours.get(position);
                releaseMediaPlayer();
                player = MediaPlayer.create(ColoursActivity.this, word.GetmAudioresourceID());
                player.start();

                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion (MediaPlayer player){
                        releaseMediaPlayer();

                    }
                });
            }
        });
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (player != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            player.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            player = null;
            Toast.makeText(ColoursActivity.this, "i'm done" , Toast.LENGTH_SHORT).show();
        }
    }
}