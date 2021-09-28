package com.example.android.miwok;

import android.media.Image;
import android.view.View;

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImagelocation = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;



    public Word(String defaulttranslation, String miwokTranslation) {
        mDefaultTranslation = defaulttranslation;
        mMiwokTranslation = miwokTranslation;
        mImagelocation = NO_IMAGE_PROVIDED;
    }

    public Word(String defaulttranslation, String miwokTranslation, int imagelocation) {
        mDefaultTranslation = defaulttranslation;
        mMiwokTranslation = miwokTranslation;
        mImagelocation = imagelocation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImagelocation() {
        return mImagelocation;
    }

    public boolean hasImage(){
        return mImagelocation != NO_IMAGE_PROVIDED;
    }


}
