package com.rajesh.smarttaskmanager;

import android.app.ActivityManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class SystemTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_task);

        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RunningAppProcessInfo> recentTasks = activityManager.getRunningAppProcesses();
        List<ProcessInfo>  processInfoList = new ArrayList<>();
        for(ActivityManager.RunningAppProcessInfo processInfo : recentTasks){
            processInfoList.add(new ProcessInfo(processInfo.processName,processInfo.pid));
        }

        ArrayAdapter<ProcessInfo> adapter = new ArrayAdapter<ProcessInfo>(this,android.R.layout.simple_list_item_2,
                android.R.id.text1,processInfoList);
        ListView listView =(ListView) findViewById(R.id.lv_system_tasks);
        listView.setAdapter(adapter);
    }

    private class ProcessInfo{
        String processName;
        int pid;
        ProcessInfo( String processName,int pid){
            this.processName = processName;
            this.pid = pid;
        }
    }

}
