package com.rajesh.smarttaskmanager.Models;

/**
 * Created by user on 16-02-2018.
 */

public class PhoneContacts {
    private  String contact_id;
    private  String contact_name;
    private  String contact_number;
    private  String contact_photo;

    public PhoneContacts(String contact_id, String contact_name, String contact_number, String contact_photo) {
        this.contact_id = contact_id;
        this.contact_name = contact_name;
        this.contact_number = contact_number;
        this.contact_photo = contact_photo;
    }

    public String getContact_id() {
        return contact_id;
    }

    public void setContact_id(String contact_id) {
        this.contact_id = contact_id;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getContact_photo() {
        return contact_photo;
    }

    public void setContact_photo(String contact_photo) {
        this.contact_photo = contact_photo;
    }
}
