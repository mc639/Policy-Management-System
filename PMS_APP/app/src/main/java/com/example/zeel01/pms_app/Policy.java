package com.example.zeel01.pms_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Policy extends AppCompatActivity {

    ListView lv;
    ProgressDialog pd;
  ArrayList <String> aa_pid,aa_pname,aa_pno,aa_sum_insure,aa_sap,aa_min_age,aa_max_age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
       lv=(ListView)findViewById(R.id.listView);

         new LoadPolicy().execute();


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(Policy.this,Policy_plan.class);
                 i.putExtra("policyid",aa_pid.get(position));
                 startActivity(i);
            }
        });

    }
    class LoadPolicy extends AsyncTask<Void,Void,Void>
    {
        String result;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
          pd=new ProgressDialog(Policy.this);
          pd.setMessage("Wait...");
            pd.setTitle("PMS");
            aa_pid=new ArrayList<>();
            aa_pname=new ArrayList<>();
            aa_pno=new ArrayList<>();
            aa_sum_insure=new ArrayList<>();
            aa_sap=new ArrayList<>();
            aa_min_age=new ArrayList<>();
            aa_max_age=new ArrayList<>();
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
         result= W_GetPolicy.getpolicy();

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
                aa_pid.add(st1.nextToken());
                aa_pname.add(st1.nextToken());
                aa_pno.add(st1.nextToken());
                aa_sum_insure.add(st1.nextToken());
                aa_sap.add(st1.nextToken());
                aa_min_age.add(st1.nextToken());
                aa_max_age.add(st1.nextToken());
                 lv.setAdapter(new mybase());
            }
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
            return aa_max_age.size();
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
         TextView t1,t2,t3,t4,t5,t6,t7;
         }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder h = null;
            if (convertView == null) {
                h = new ViewHolder();
                convertView = inflate.inflate(R.layout.policy_row, null);
                h.t1 = (TextView) convertView.findViewById(R.id.textView2);
                h.t2 = (TextView) convertView.findViewById(R.id.textView3);
                h.t3 = (TextView) convertView.findViewById(R.id.textView4);
                h.t4 = (TextView) convertView.findViewById(R.id.textView5);
                h.t5 = (TextView) convertView.findViewById(R.id.textView6);
                h.t6 = (TextView) convertView.findViewById(R.id.textView7);
                h.t7 = (TextView) convertView.findViewById(R.id.textView8);
                convertView.setTag(h);
            } else
            {
                h=(ViewHolder)convertView.getTag();
            }

             h.t1.setText("Policy ID : "+aa_pid.get(position)+"");
            h.t2.setText("Policy Number : "+aa_pno.get(position)+"");
            h.t3.setText("Policy Name : "+aa_pname.get(position)+"");
            h.t4.setText("Sum Assured : "+aa_sum_insure.get(position)+"");
            h.t5.setText("Surrender Policy Amount Percentage : "+aa_sap.get(position)+" % ");
            h.t6.setText("Max age : "+aa_max_age.get(position)+"");
            h.t7.setText("Min age : "+aa_min_age.get(position)+"");

            h.t1.setVisibility(View.GONE);
            return convertView;
        }
    }
}
