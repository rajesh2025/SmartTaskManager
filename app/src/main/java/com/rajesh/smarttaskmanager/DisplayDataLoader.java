package com.rajesh.smarttaskmanager;

import android.app.LoaderManager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

/**
 * Created by user on 16-02-2018.
 */

public class DisplayDataLoader extends  CursorLoader{

    public static String CONTACT_ID =  ContactsContract.Contacts._ID;
    public static String CONTACT_NAME =  ContactsContract.Contacts.DISPLAY_NAME;
//    public static String CONTACT_DATA =  ContactsContract.Contacts.CONTENT_TYPE;
//    public  static String CONTACT_PHOTO =  ContactsContract.Contacts.Photo.DISPLAY_PHOTO;


            private  static Uri CONTACT_URI = ContactsContract.Contacts.CONTENT_URI;

    private static String display_column[] =new String[]{
            CONTACT_ID,
            CONTACT_NAME,
//            CONTACT_DATA,
//            CONTACT_PHOTO
    };

     DisplayDataLoader(Context context) {
        super(context,CONTACT_URI,null,null,null,null);

    }

}

