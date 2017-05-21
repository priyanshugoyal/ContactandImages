package com.example.priyanshu.assignment;

/**
 * Created by Priyanshu on 18-May-17.
 */

public class Contact {


    private String mname;
    private String mnumber;
    public Contact(String name, String number)
    {
        mname=name;
        mnumber=number;
    }
    public String getname() {
        return mname;
    }

    public String getnumber() {
        return mnumber;
    }

}
