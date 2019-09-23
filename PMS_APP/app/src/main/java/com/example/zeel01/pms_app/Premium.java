package com.example.zeel01.pms_app;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class Premium extends AppCompatActivity {
    ListView lv;
    ProgressDialog pd;
    String userpolicyid;
    ArrayList<String> aa_premium_id,aa_policy_name,aa_plan_name,aa_payment_date,aa_amount,aa_cheque_number,aa_paymentmode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium);
        lv=(ListView)findViewById(R.id.listView);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        userpolicyid=b.getString("userpolicyid");
        Toast.makeText(Premium.this,userpolicyid,Toast.LENGTH_LONG).show();
        new Premium.getpremium().execute();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
    class getpremium extends AsyncTask<Void,Void,Void>
    {
        String result;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(Premium.this);
            pd.setMessage("Wait...");
            pd.setTitle("PMS");
            aa_premium_id=new ArrayList<>();
            aa_policy_name=new ArrayList<>();
            aa_plan_name=new ArrayList<>();
            aa_payment_date=new ArrayList<>();
            aa_amount=new ArrayList<>();
            aa_cheque_number=new ArrayList<>();
            aa_paymentmode=new ArrayList<>();
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            result= W_GetPremium.getpremium(userpolicyid);
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
                aa_premium_id.add(st1.nextToken());
                aa_policy_name.add(st1.nextToken());
                aa_plan_name.add(st1.nextToken());
                aa_payment_date.add(st1.nextToken());
                aa_amount.add(st1.nextToken());
                aa_cheque_number.add(st1.nextToken());
                aa_paymentmode.add(st1.nextToken());
            }

            lv.setAdapter(new Premium.mybase());
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
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Premium.mybase.ViewHolder h = null;
            if (convertView == null) {
                h = new Premium.mybase.ViewHolder();
                convertView = inflate.inflate(R.layout.premium_row, null);
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
                h=(Premium.mybase.ViewHolder)convertView.getTag();
            }

            h.t1.setText("Premium ID : "+aa_premium_id.get(position)+"");
            h.t2.setText("Policy Name : "+aa_policy_name.get(position)+"");
            h.t3.setText("Plan Name : "+aa_plan_name.get(position)+"");
            h.t4.setText("Premium Payment Date : "+aa_payment_date.get(position)+"");
            h.t5.setText("Premium Amount : "+aa_amount.get(position)+"");
            h.t6.setText("Cheque Number : "+aa_cheque_number.get(position)+"");
            if(aa_paymentmode.get(position).equals("0"))
            {
                h.t7.setText("Payment Mode : Cash ");
                h.t6.setVisibility(View.GONE);
            }
            else
            {
                h.t7.setText("Payment Mode : Cheque ");
            }
            h.t1.setVisibility(View.GONE);
            return convertView;
        }
    }
}
