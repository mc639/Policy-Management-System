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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Policy_plan extends AppCompatActivity {
    ListView lv;
    ProgressDialog pd;
    String policyid;
    SharedPreferences shp;
    String uid;
    ArrayList<String> aa_plan_id,aa_policy_id,aa_tbr,aa_r2to5,aa_ra5,aa_pmsm,aa_pmoy,aa_noy,aa_plan_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_plan);
        lv=(ListView)findViewById(R.id.listView);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        policyid=b.getString("policyid");
         shp=getSharedPreferences("mypref",0);
        uid=shp.getString("rid","");
        Toast.makeText(Policy_plan.this,policyid,Toast.LENGTH_LONG).show();
        new Policy_plan.LoadPolicyplan().execute();


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
    class LoadPolicyplan extends AsyncTask<Void,Void,Void>
    {
        String result,id;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(Policy_plan.this);
            pd.setMessage("Wait...");
            pd.setTitle("PMS");
            aa_plan_id=new ArrayList<>();
            aa_policy_id=new ArrayList<>();
            aa_tbr=new ArrayList<>();
            aa_r2to5=new ArrayList<>();
            aa_ra5=new ArrayList<>();
            aa_pmsm=new ArrayList<>();
            aa_pmoy=new ArrayList<>();
            aa_noy=new ArrayList<>();
            aa_plan_name=new ArrayList<>();
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            result= W_GetPolicyPlan.getpolicyplan(policyid);
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
                aa_plan_id.add(st1.nextToken());
                aa_policy_id.add(st1.nextToken());
                aa_tbr.add(st1.nextToken());
                aa_r2to5.add(st1.nextToken());
                aa_ra5.add(st1.nextToken());
                aa_pmsm.add(st1.nextToken());
                aa_pmoy.add(st1.nextToken());
                aa_noy.add(st1.nextToken());
                aa_plan_name.add(st1.nextToken());

            }

            lv.setAdapter(new Policy_plan.mybase());
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
            return aa_plan_name.size();
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
            Button btn;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Policy_plan.mybase.ViewHolder h = null;
            if (convertView == null) {
                h = new Policy_plan.mybase.ViewHolder();
                convertView = inflate.inflate(R.layout.policy_plan_row, null);
                h.t1 = (TextView) convertView.findViewById(R.id.textView2);
                h.t2 = (TextView) convertView.findViewById(R.id.textView3);
                h.t3 = (TextView) convertView.findViewById(R.id.textView4);
                h.t4 = (TextView) convertView.findViewById(R.id.textView5);
                h.t5 = (TextView) convertView.findViewById(R.id.textView6);
                h.t6 = (TextView) convertView.findViewById(R.id.textView7);
                h.t7 = (TextView) convertView.findViewById(R.id.textView8);
                h.t8 = (TextView) convertView.findViewById(R.id.textView9);
                h.t9 = (TextView) convertView.findViewById(R.id.textView10);
                 h.btn=(Button)convertView.findViewById(R.id.button);

                convertView.setTag(h);
            } else
            {
                h=(Policy_plan.mybase.ViewHolder)convertView.getTag();
            }

            h.btn.setId(Integer.parseInt(aa_plan_id.get(position)));
            h.t1.setText("Plan ID : "+aa_plan_id.get(position)+"");
            h.t2.setText("Policy Name : "+aa_policy_id.get(position)+"");
            h.t3.setText("Tabular Rate : "+aa_tbr.get(position)+"");
            h.t4.setText("Rebet percentage on Policy Amount 2 to 5 lac : "+aa_r2to5.get(position)+" % ");
            h.t5.setText("Rebet percentage on Policy Amount 5 lac and Above : "+aa_ra5.get(position)+" % ");
            h.t6.setText("Rebet on 6 Months Premium payment : "+aa_pmsm.get(position)+" % ");
            h.t7.setText("Rebet on 12 Months Premium payment : "+aa_pmoy.get(position)+" % ");
            h.t8.setText("Number of years : "+aa_noy.get(position)+"  Years ");
            h.t9.setText("Plan Name : "+aa_plan_name.get(position)+"");
            h.t1.setVisibility(View.GONE);

            h.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String pid=String.valueOf(v.getId());
                     new AddToWishList(pid).execute();
                   }
            });

            return convertView;
        }
    }


    class AddToWishList extends AsyncTask<Void,Void,Void>
    {
        String pid;

        AddToWishList(String pid)
        {
            this.pid=pid;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(Policy_plan.this);
            pd.setMessage("Wait...");
            pd.setTitle("PMS");
           pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
           W_AddToWishlist.add(uid,pid);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pd.dismiss();
            Toast.makeText(Policy_plan.this,"Policy Plan Added In Your Wishlist",Toast.LENGTH_LONG).show();
        }
    }
}
