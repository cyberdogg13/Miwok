package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyMebersActivity extends AppCompatActivity {
    MediaPlayer player = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_layout);

        final ArrayList<Word> familyMembers = new ArrayList<Word>();
        familyMembers.add(new Word("father", "әpә",R.drawable.family_father, R.raw.family_father));
        familyMembers.add(new Word("mother", "әṭa",R.drawable.family_mother, R.raw.family_mother));
        familyMembers.add(new Word("son", "angsi",R.drawable.family_son, R.raw.family_son));
        familyMembers.add(new Word("daughter", "tune",R.drawable.family_daughter, R.raw.family_daughter));
        familyMembers.add(new Word("older brother", "taachi",R.drawable.family_older_brother, R.raw.family_older_brother));
        familyMembers.add(new Word("younger brother", "chalitti",R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyMembers.add(new Word("older sister", "teṭe",R.drawable.family_older_sister, R.raw.family_older_sister));
        familyMembers.add(new Word("younger sister", "kolliti",R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyMembers.add(new Word("grandmother", "ama",R.drawable.family_grandmother, R.raw.family_grandmother));
        familyMembers.add(new Word("grandfather", "paapa",R.drawable.family_grandfather, R.raw.family_grandfather));

        WordAdapter adapter = new WordAdapter(this, familyMembers,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = familyMembers.get(position);
                player = MediaPlayer.create(FamilyMebersActivity.this, word.GetmAudioresourceID());
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
            Toast.makeText(FamilyMebersActivity.this, "i'm done" , Toast.LENGTH_SHORT).show();
        }
    }
}