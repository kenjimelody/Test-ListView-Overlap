package com.superhardcode.www.test_listviewoverlap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.superhardcode.www.test_listviewoverlap.adapter.ListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview = null;
    private ListViewAdapter adapter = null;
    private List<HashMap<String, Object>> data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<HashMap<String, Object>>();
        for(int i=0; i<10; i++) {

            HashMap<String, Object> obj = new HashMap<String, Object>();
            obj.put("title", "Cat No." + (i+1));
            data.add(obj);
        }

        listview = (ListView) findViewById(R.id.home_list);
        adapter = new ListViewAdapter(this, listview);
        adapter.fetch(data);
    }
}
