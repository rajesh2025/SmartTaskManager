package com.rajesh.smarttaskmanager;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rajesh.smarttaskmanager.Adapters.DataCursorAdapter;
import com.rajesh.smarttaskmanager.Models.PhoneContacts;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;
import timber.log.Timber;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class BlankFragment extends BaseFragment implements SecondBlankFragment.OnFragmentInteractionListener,
        LoaderManager.LoaderCallbacks<Cursor> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private final int loaderID = 111;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private  RecyclerView rv_contact_list;
private DataCursorAdapter dataCursorAdapter;
    private OnFragmentInteractionListener mListener;
        private List<PhoneContacts> contactList;

    public BlankFragment() {
        // Required empty public constructor
        contactList = new ArrayList<PhoneContacts>();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters

    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Timber.i(" onSaveInstanceState");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         rv_contact_list = (RecyclerView) view.findViewById(R.id.rv_contact_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv_contact_list.setLayoutManager(mLayoutManager);
        rv_contact_list.setItemAnimator(new DefaultItemAnimator());
        dataCursorAdapter = new DataCursorAdapter(getActivity());
        rv_contact_list.setAdapter(dataCursorAdapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        ((AppCompatActivity)context).getSupportLoaderManager().initLoader(loaderID,null,this);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new DisplayDataLoader(getContext());
    }



    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
//        switch (loader.getId()) {
//            case loaderID:
                setUpList(data);
//        }

    }


    private void setUpList(Cursor data) {
        if (data != null) {
            while (data.moveToNext()){
                String _id  = data.getString(data.getColumnIndex(DisplayDataLoader.CONTACT_ID));
                String _name = data.getString(data.getColumnIndex(DisplayDataLoader.CONTACT_NAME));
//                String _number = data.getString(data.getColumnIndex(DisplayDataLoader.CONTACT_DATA));
//                String _photo = data.getString(data.getColumnIndex(DisplayDataLoader.CONTACT_PHOTO));
                contactList.add(new PhoneContacts(_id,_name,"",""));
            }
        }
      dataCursorAdapter.setContactList(contactList);
        dataCursorAdapter.notifyDataSetChanged();

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
//        contactList.clear();
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
