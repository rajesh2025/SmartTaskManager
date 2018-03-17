package com.rajesh.smarttaskmanager.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rajesh.smarttaskmanager.DisplayDataLoader;
import com.rajesh.smarttaskmanager.Models.PhoneContacts;
import com.rajesh.smarttaskmanager.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by user on 16-02-2018.
 */

public class DataCursorAdapter extends RecyclerView.Adapter<DataCursorAdapter.ContactDataHolder> {
   private LayoutInflater inflater;
   private List<PhoneContacts> contactList;

    public DataCursorAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setContactList(List<PhoneContacts> contactList) {
        this.contactList = contactList;
    }

    class ContactDataHolder extends RecyclerView.ViewHolder{
        TextView tv_contact_name ;
        TextView tv_contact_number;

        ContactDataHolder(View itemView) {
            super(itemView);
            tv_contact_name = (TextView) itemView.findViewById(R.id.tv_display_name);
            tv_contact_number = (TextView) itemView.findViewById(R.id.tv_display_number);
        }
    }


    @Override
    public ContactDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView =  inflater.inflate(R.layout.view_contact_list_item,parent,false);
        return new ContactDataHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ContactDataHolder holder, int position) {
        holder.tv_contact_name.setText(contactList.get(position).getContact_name());
        holder.tv_contact_number.setText(contactList.get(position).getContact_number());
    }

    @Override
    public int getItemCount() {
        if(contactList==null)
            return 0;
        else
        return contactList.size();
    }
}
