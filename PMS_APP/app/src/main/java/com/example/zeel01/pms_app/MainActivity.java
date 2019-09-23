package com.example.zeel01.pms_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    ProgressDialog pd;
    EditText t1,t2;
    Button btn,btn2;
   SharedPreferences shp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      t1=(EditText)findViewById(R.id.t1);
        t2=(EditText)findViewById(R.id.t2);
        btn=(Button)findViewById(R.id.btn);
        btn2=(Button)findViewById(R.id.button5);

        StrictMode.ThreadPolicy ply = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(ply);

        shp=getSharedPreferences("mypref",0);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CheckLogin().execute();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,forgot_password_1.class));
            }
        });

    }


    class CheckLogin extends AsyncTask<Void,Void,Void>
    {
      String result,l,p;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           pd=new ProgressDialog(MainActivity.this);
           pd.setMessage("Wait..");
            pd.setTitle("PMS");
           l=t1.getText().toString();
            p=t2.getText().toString();
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

           result= W_Checklogin.checklogin(l,p);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
           pd.dismiss();
           if(result.equals("Invalid Loginid And Password")) {
               Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
           }
            else
           {
               StringTokenizer st=new StringTokenizer(result,"|");
               Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();



               String rid=st.nextToken();
               String name=st.nextToken();
               String photo=st.nextToken();
               SharedPreferences.Editor ed=shp.edit();
               ed.putString("rid",rid);
               ed.putString("name",name);
               ed.putString("photo",photo);
               ed.commit();
               Intent i=new Intent(MainActivity.this,Welcome.class);
               startActivity(i);
               finish();



           }
        }
    }
}
