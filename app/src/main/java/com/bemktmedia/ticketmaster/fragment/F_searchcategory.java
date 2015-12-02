package com.bemktmedia.ticketmaster.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bemktmedia.ticketmaster.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by geovannyinca on 29/11/15.
 */
public class F_searchcategory extends Fragment {
    private ListView lv_searchcategory;
    View f_searchcategoryview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //return super.onCreateView(inflater, container, savedInstanceState);
        //return inflater.inflate(R.layout.f_home,container,false);
        f_searchcategoryview=inflater.inflate(R.layout.f_home,container,false);
        lv_searchcategory=(ListView)f_searchcategoryview.findViewById(R.id.lv_searchresult);

        String[] values = new String[] { "SPORTS", "CONCERTS", "THEATER & COMEDY",
                "TOP EVENTS", "HAPPENING TODAY", "RECENTLY VIEWWED" };
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            Log.d("array:", values[i]);
            list.add(values[i]);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_1, list);

        lv_searchcategory.setAdapter(adapter);
        lv_searchcategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                list.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });

        return f_searchcategoryview;
    }
    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
}
