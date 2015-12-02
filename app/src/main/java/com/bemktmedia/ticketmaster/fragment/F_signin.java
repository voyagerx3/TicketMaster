package com.bemktmedia.ticketmaster.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bemktmedia.ticketmaster.R;

/**
 * Created by geovannyinca on 28/11/15.
 */
public class F_signin extends Fragment {
    View f_signin;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        f_signin=inflater.inflate(R.layout.f_signin,container,false);
        return f_signin;
    }
}
