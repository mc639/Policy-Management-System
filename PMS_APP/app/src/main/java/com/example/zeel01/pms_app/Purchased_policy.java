package com.example.zeel01.pms_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Purchased_policy extends AppCompatActivity {
    ListView lv;
    ProgressDialog pd;
    String id;
    SharedPreferences shp;
    ArrayList<String> aa_user_pid,aa_policy_name,aa_plan_name,aa_ppd,aa_policy_amnt,aa_nomname,aa_nomrel,aa_premtype,aa_policy_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchased_policy);
        lv=(ListView)findViewById(R.id.listView);
        shp=getSharedPreferences("mypref",0);
        id=shp.getString("rid","");
        Toast.makeText(Purchased_policy.this,id,Toast.LENGTH_LONG).show();
        new Purchased_policy.Loadpurchasedpolicy().execute();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(Purchased_policy.this,Premium.class);
                i.putExtra("userpolicyid",aa_user_pid.get(position));
                startActivity(i);
            }
        });
    }

    class Loadpurchasedpolicy extends AsyncTask<Void,Void,Void>
    {
        String result;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(Purchased_policy.this);
            pd.setMessage("Wait...");

            aa_user_pid=new ArrayList<>();
            aa_policy_name=new ArrayList<>();
            aa_plan_name=new ArrayList<>();
            aa_ppd=new ArrayList<>();
            aa_policy_amnt=new ArrayList<>();
            aa_nomname=new ArrayList<>();
            aa_nomrel=new ArrayList<>();
            aa_premtype=new ArrayList<>();
            aa_policy_status=new ArrayList<>();
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            result= W_GetPurchasedPolicy.getpurchasedpolicy(id);
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
                aa_user_pid.add(st1.nextToken());
                aa_policy_name.add(st1.nextToken());
                aa_plan_name.add(st1.nextToken());
                aa_ppd.add(st1.nextToken());
                aa_policy_amnt.add(st1.nextToken());
                aa_nomname.add(st1.nextToken());
                aa_nomrel.add(st1.nextToken());
                aa_premtype.add(st1.nextToken());
                aa_policy_status.add(st1.nextToken());
            }

            lv.setAdapter(new Purchased_policy.mybase());
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
            return aa_user_pid.size();
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
            TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Purchased_policy.mybase.ViewHolder h = null;
            if (convertView == null) {
                h = new Purchased_policy.mybase.ViewHolder();
                convertView = inflate.inflate(R.layout.purchasedpolicy_row, null);
                h.t1 = (TextView) convertView.findViewById(R.id.textView2);
                h.t2 = (TextView) convertView.findViewById(R.id.textView3);
                h.t3 = (TextView) convertView.findViewById(R.id.textView4);
                h.t4 = (TextView) convertView.findViewById(R.id.textView5);
                h.t5 = (TextView) convertView.findViewById(R.id.textView6);
                h.t6 = (TextView) convertView.findViewById(R.id.textView7);
                h.t7 = (TextView) convertView.findViewById(R.id.textView8);
                h.t8 = (TextView) convertView.findViewById(R.id.textView9);
                h.t9 = (TextView) convertView.findViewById(R.id.textView10);
                convertView.setTag(h);
            } else
            {
                h=(Purchased_policy.mybase.ViewHolder)convertView.getTag();
            }

            h.t1.setText("User Policy ID : "+aa_user_pid.get(position)+"");
            h.t2.setText("Policy Name : "+aa_policy_name.get(position)+"");
            h.t3.setText("Plan Name : "+aa_plan_name.get(position)+"");
            h.t4.setText("Purchase Policy Date : "+aa_ppd.get(position)+"");
            h.t5.setText("Policy Amount : "+aa_policy_amnt.get(position)+"");
            h.t6.setText("Nominee Name : "+aa_nomname.get(position)+"");
            h.t7.setText("Nominee Relationship : "+aa_nomrel.get(position)+"");
            if(aa_premtype.get(position).equals("0"))
            {
                h.t8.setText("Premium Type : Yearly ");
            }
            else if(aa_premtype.get(position).equals("1"))
            {
                h.t8.setText("Premium Type : Half-Yearly ");
            }
            else if(aa_premtype.get(position).equals("2"))
            {
                h.t8.setText("Premium Type : Quaterly ");
            }
            else if(aa_premtype.get(position).equals("3"))
            {
                h.t8.setText("Premium Type : Monthly ");
            }

            if(aa_policy_status.get(position).equals("1"))
            {

                h.t9.setText("Policy Status : Exist ");
            }
            else
            {
                h.t9.setText("Policy Status : Lapsed ");
            }
            h.t1.setVisibility(View.GONE);
            return convertView;
        }
    }

}
