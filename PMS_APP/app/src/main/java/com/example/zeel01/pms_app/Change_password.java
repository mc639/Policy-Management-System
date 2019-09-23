package com.example.zeel01.pms_app;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Change_password extends AppCompatActivity {
    ProgressDialog pd;
    EditText t3,t4;

    Button btn;
    SharedPreferences shp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        t3=(EditText)findViewById(R.id.editText);
        t4=(EditText)findViewById(R.id.editText2);
        btn=(Button)findViewById(R.id.button);
        shp=getSharedPreferences("mypref",0);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Change_password.changepassword().execute();
            }
        });
    }

    class changepassword extends AsyncTask<Void,Void,Void> {
        String result,id,op,np,test;
        @Override
        protected void onPreExecute() {

            pd=new ProgressDialog(Change_password.this);
            pd.setMessage("Wait..");
            pd.setTitle("PMS");
            shp=getSharedPreferences("mypref",0);
            id = shp.getString("rid","");
            op = t3.getText().toString();
            np = t4.getText().toString();
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            test = id+" "+op+" "+np;
            result = W_Changepassword.changepassword(id,op,np);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pd.dismiss();
            //Toast.makeText(Change_password.this,test,Toast.LENGTH_LONG).show();
            Toast.makeText(Change_password.this, result, Toast.LENGTH_LONG).show();
        }
    }

}

