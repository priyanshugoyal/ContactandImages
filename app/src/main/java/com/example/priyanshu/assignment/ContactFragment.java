package com.example.priyanshu.assignment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Priyanshu on 21-May-17.
 */

public class ContactFragment extends Fragment {
    ArrayList<Contact> contact=new ArrayList<>();
    ListView listView;
    public static final int RequestPermissionCode = 1;
ContactAdapter adapter;
    View rootView;
    String name, number;

    public ContactFragment() {

    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.contact_layout, container, false);
        adapter = new ContactAdapter(getActivity(), contact);

        listView = (ListView) rootView.findViewById(R.id.listview);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            // Do something for lollipop and above versions
            accesscontact();

        }
else
        {
            GetContactsIntoArrayList();
        }




        return rootView;
    }
    public void GetContactsIntoArrayList(){
contact.clear();
        Cursor cursor = getActivity().getApplicationContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);

        while (cursor.moveToNext()) {

            name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

            number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            contact.add(new Contact(name,number));
        }
        cursor.close();
        adapter=new ContactAdapter(getActivity(),contact);
        listView=(ListView)rootView.findViewById(R.id.listview);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();






    }
    protected void accesscontact()
    {
    if (ContextCompat.checkSelfPermission(getActivity(),
    Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.READ_CONTACTS},
                RequestPermissionCode);
    } else {

        GetContactsIntoArrayList();


    }
}


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    GetContactsIntoArrayList();



                } else {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Can't read contact_layout without permission", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
    }





}