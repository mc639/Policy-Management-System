package com.example.zeel01.pms_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class wishlist extends AppCompatActivity {

    ListView lv;
    ProgressDialog pd;
    String id;
    SharedPreferences shp;
    ArrayList<String> aa_wishlist_id,aa_policy_name,aa_plan_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        lv=(ListView)findViewById(R.id.listView);
        shp=getSharedPreferences("mypref",0);
        id=shp.getString("rid","");
        Toast.makeText(wishlist.this,id,Toast.LENGTH_LONG).show();
        new wishlist.getwishlist().execute();

    }

    class getwishlist extends AsyncTask<Void,Void,Void>
    {
        String result;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(wishlist.this);
            pd.setMessage("Wait...");
            aa_wishlist_id=new ArrayList<>();
            aa_policy_name=new ArrayList<>();
            aa_plan_name=new ArrayList<>();
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            result= W_GetWishlist.get(id);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pd.dismiss();
            StringTokenizer st=new StringTokenizer(result,"#");
            while(st.hasMoreTokens())
            {
                String recod=st.nextToken();
                StringTokenizer st1=new StringTokenizer(recod,"|");
                aa_wishlist_id.add(st1.nextToken());
                aa_policy_name.add(st1.nextToken());
                aa_plan_name.add(st1.nextToken());

            }

            lv.setAdapter(new wishlist.mybase());
        }
    }

    class mybase extends BaseAdapter
    {
        LayoutInflater inflate;
        mybase()
        {
            inflate=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            return aa_policy_name.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        class ViewHolder {
            TextView t1,t2,t3;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            wishlist.mybase.ViewHolder h = null;
            if (convertView == null) {
                h = new wishlist.mybase.ViewHolder();
                convertView = inflate.inflate(R.layout.wishlist_row, null);
                h.t1 = (TextView) convertView.findViewById(R.id.textView2);
                h.t2 = (TextView) convertView.findViewById(R.id.textView3);
                h.t3 = (TextView) convertView.findViewById(R.id.textView4);
                convertView.setTag(h);
            } else
            {
                h=(wishlist.mybase.ViewHolder)convertView.getTag();
            }

            h.t1.setText("Wishlist ID : "+aa_wishlist_id.get(position)+"");
            h.t2.setText("Plan Name : "+aa_plan_name.get(position)+"");
            h.t3.setText("Policy Name : "+aa_policy_name.get(position)+"");
            h.t1.setVisibility(View.GONE);
            return convertView;
        }
    }

}
