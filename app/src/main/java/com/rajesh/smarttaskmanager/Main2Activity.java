package com.rajesh.smarttaskmanager;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import timber.log.Timber;

public class Main2Activity extends AppCompatActivity implements SecondBlankFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setTitle("Main2Activity Activity");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setSupportActionBar(toolbar);
        Timber.tag("Main2Activity LifeCycle");
        Timber.i("Main2Activity Created");
        android.support.v4.app.FragmentTransaction f2transaction = getSupportFragmentManager().beginTransaction();
        Fragment bFragment = new SecondBlankFragment();
        f2transaction.add(bFragment,"blank_fragment");
        f2transaction.commit();
     //   Timber.i("is fragment visible %s", bFragment.isVisible());

      //  Fragment fragmentObj = getSupportFragmentManager().findFragmentByTag("blank_fragment");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Timber.i("Activity Started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.i("Activity Stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Timber.i("Activity Paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.i("Activity Resumed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Timber.i("Activity Restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.i("Activity Destroyed");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
