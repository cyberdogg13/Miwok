package com.example.android.miwok;

import android.media.Image;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public Word(String defaulttranslation, String miwokTranslation){
        mDefaultTranslation = defaulttranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public String getDefaultTranslation (){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation (){
        return mMiwokTranslation;
    }
}
