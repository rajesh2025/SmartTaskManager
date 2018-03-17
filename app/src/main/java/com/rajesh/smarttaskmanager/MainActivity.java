package com.rajesh.smarttaskmanager;

import android.*;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;
import timber.log.Timber;
@RuntimePermissions
public class MainActivity extends AppCompatActivity implements ItemListDialogFragment.Listener,BlankFragment.OnFragmentInteractionListener
,SecondBlankFragment.OnFragmentInteractionListener{
private EditText et_add_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        TextView textView= (TextView) toolbar.findViewById(R.id.tv_toolbar_title);
        textView.setText("Main Activity");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Timber.tag("MainActivity LifeCycle");
        Timber.i("MainActivity Created");
        Log.i("MainActivity","MainActivity Created");
                MainActivityPermissionsDispatcher.readContactWithPermissionCheck(this);

//        ItemListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "ItemListDialogFragment");

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
    @NeedsPermission(android.Manifest.permission.READ_CONTACTS)
    public void readContact() {
        android.support.v4.app.FragmentTransaction f2transaction = getSupportFragmentManager().beginTransaction();
        android.support.v4.app.Fragment bFragment = BlankFragment.newInstance("","");
        f2transaction.add(R.id.fl_main_fragment,bFragment,"blank_fragment");
        f2transaction.commit();
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Timber.i(" new intent");
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
    public void onItemClicked(int position) {


    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Timber.i("Activity onSaveInstanceState");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Timber.i(" onSaveInstanceState");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
//        Intent newIntent = new Intent(MainActivity.this,Main2Activity.class);
//        startActivity(newIntent);
    }

    @OnShowRationale(android.Manifest.permission.READ_CONTACTS)
    void showRationaleForReadContact(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage("Import permission")
                .setPositiveButton("allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton("deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .show();
    }

    @OnPermissionDenied(android.Manifest.permission.READ_CONTACTS)
    void showDeniedForReadContact() {
        Toast.makeText(this, "read contact permission denied", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(android.Manifest.permission.READ_CONTACTS)
    void showNeverAskForContacts() {
        Toast.makeText(this, "do not ask again", Toast.LENGTH_SHORT).show();
    }
}
