package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>{

    private int mColourResourceID;

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    public WordAdapter(Activity context, ArrayList<Word> numbers, int ColourResourceID){
        super(context, 0, numbers );
        mColourResourceID = ColourResourceID;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        ImageView defaultImageView = (ImageView) listItemView.findViewById(R.id.plaatje);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
//        defaultImageView.setImageResource(currentWord.getImagelocation());

        ImageView img = (ImageView) defaultImageView.findViewById(R.id.plaatje);

        if (currentWord.hasImage()){
            img.setImageResource(currentWord.getImagelocation());
            img.setVisibility(View.VISIBLE);
        }
        else{img.setVisibility(View.GONE);}

        View textcontainer = listItemView.getRootView().findViewById(R.id.text_container);
        int Colour = ContextCompat.getColor(getContext(),  mColourResourceID);
        textcontainer.setBackgroundColor(Colour);




        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
