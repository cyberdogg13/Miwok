package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PrhasesActivity extends AppCompatActivity {
    MediaPlayer player = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_layout);

        final ArrayList<Word> phrases = new ArrayList<Word>();
        phrases.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        phrases.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        phrases.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        phrases.add(new Word("How are you feeling?", "michәksәs?",  R.raw.phrase_how_are_you_feeling));
        phrases.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        phrases.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        phrases.add(new Word("yes, i'm coming", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        phrases.add(new Word("i'm coming", "әәnәm", R.raw.phrase_im_coming));
        phrases.add(new Word("lets go", "yoowutis", R.raw.phrase_lets_go));
        phrases.add(new Word("come here", "әnni'nem", R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, phrases,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = phrases.get(position);
                releaseMediaPlayer();
                player = MediaPlayer.create(PrhasesActivity.this, word.GetmAudioresourceID());
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
            Toast.makeText(PrhasesActivity.this, "i'm done" , Toast.LENGTH_SHORT).show();
        }
    }
}