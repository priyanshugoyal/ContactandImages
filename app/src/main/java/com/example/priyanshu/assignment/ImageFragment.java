package com.example.priyanshu.assignment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by Priyanshu on 18-May-17.
 */

public class ImageFragment extends Fragment {
    View rootView;

    public ImageFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.image_layout, container, false);
        GridView gridview = (GridView)rootView.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(getActivity()));
        Configuration config = getResources().getConfiguration();

        //FragmentManager fragmentManager = getFragmentManager();
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        /**
         * Check the device orientation and act accordingly
         */

        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            /**
             * Landscape mode of the device
             */
            //LandscapeFragment ls_fragment = new LandscapeFragment();
            //fragmentTransaction.replace(android.R.id.content, ls_fragment);
            gridview.setNumColumns(3);
            gridview.setColumnWidth(200);
        }else{
            /**
             * Portrait mode of the device
             */
            //PotraitFragment pm_fragment = new PotraitFragment();
            //fragmentTransaction.replace(android.R.id.content, pm_fragment);
            gridview.setNumColumns(2);
        }
        //fragmentTransaction.commit();

        return rootView;
    }
}
