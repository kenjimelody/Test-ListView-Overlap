package com.superhardcode.www.test_listviewoverlap.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.superhardcode.www.test_listviewoverlap.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Thanisak Piyasaksiri on 7/4/16 AD.
 */
public class ListViewAdapter  {

    private Context context;
    private ListView listViewObj;
    private List<HashMap<String, Object>> dataListObj;

    private ListAdapter adapter;

    public ListViewAdapter(Context context, ListView listViewObj) {

        this.context = context;
        this.listViewObj = listViewObj;
        this.dataListObj = new ArrayList<HashMap<String, Object>>();

        this.adapter = new ListAdapter(this.context, R.layout.row_listview, this.dataListObj);
        this.listViewObj.setAdapter(this.adapter);
    }

    public void fetch(List<HashMap<String, Object>> dataListObj) {

        this.dataListObj.clear();
        for(int i=0; i<dataListObj.size(); i++) {
            this.dataListObj.add((HashMap<String, Object>) dataListObj.get(i));
        }

        if(this.adapter != null)
            this.adapter.notifyDataSetChanged();
    }

    static class ViewHolder {

        ImageView row_img;
        TextView row_text;
        RelativeLayout row_frame;
    }

    class ListAdapter extends ArrayAdapter<HashMap<String, Object>> {

        Context context;
        private int resId = 0;
        private List<HashMap<String, Object>> items;

        public ListAdapter(Context context, int textViewResourceId, List<HashMap<String, Object>> items) {

            super(context, textViewResourceId, items);
            this.items = items;
            this.context = context;
            this.resId = textViewResourceId;
        }

        public int getCount() {
            return items.size();
        }

        public HashMap<String, Object> getItem(int position) {
            return items.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            View v = convertView;
            final int positions = position;

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(this.resId, null);

                holder = new ViewHolder();
                holder.row_img = (ImageView) v.findViewById(R.id.row_img);
                holder.row_text = (TextView) v.findViewById(R.id.row_text);
                holder.row_frame = (RelativeLayout) v.findViewById(R.id.row_frame);
                v.setTag(holder);

            } else {
                holder = (ViewHolder) v.getTag();
            }

            final HashMap<String, Object> o = (HashMap<String, Object>) items.get(positions);
            holder.row_text.setText(String.valueOf(o.get("title")));

            if((position%2) == 0) {
                holder.row_frame.setBackgroundResource(R.drawable.border_cyan);
            } else {
                holder.row_frame.setBackgroundResource(R.drawable.border_pink);
            }

            return v;
        }
    }
}
