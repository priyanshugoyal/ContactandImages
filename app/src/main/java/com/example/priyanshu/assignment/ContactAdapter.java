package com.example.priyanshu.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Priyanshu on 18-May-17.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {
    private TextView nametextview;
    private Context context;
    private TextView numbertextview;
    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        super(context, R.layout.contact_layout, contacts);


    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.contact_list_item, parent, false);
        }
        Contact currentContact=getItem(position);
        nametextview=(TextView)listItemView.findViewById(R.id.contactname);
        numbertextview=(TextView)listItemView.findViewById(R.id.contactnumber);
        numbertextview.setText(currentContact.getnumber());
        nametextview.setText(currentContact.getname());


        return listItemView;
    }
}

