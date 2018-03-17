package com.rajesh.smarttaskmanager;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {
private static  String CLASS_NAME = BaseFragment.class.getName().
    replace("com.rajesh.smarttaskmanager","");

    public BaseFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Timber.i(CLASS_NAME+" onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.i(CLASS_NAME+" onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        Timber.i(CLASS_NAME+" onCreateView");
        return textView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.i(CLASS_NAME+" onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Timber.i(CLASS_NAME+" onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Timber.i(CLASS_NAME+" onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Timber.i(CLASS_NAME+" onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Timber.i(CLASS_NAME+" onResume");
    }

    @Override
    public void onStop() {
        super.onStop();
        Timber.i(CLASS_NAME+" onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.i(CLASS_NAME+" onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Timber.i(CLASS_NAME+" onDetach");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Timber.i(CLASS_NAME+" onDestroyView");
    }
}
