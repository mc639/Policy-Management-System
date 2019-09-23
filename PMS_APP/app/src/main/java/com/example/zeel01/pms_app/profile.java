package com.example.zeel01.pms_app;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.StringTokenizer;

public class profile extends AppCompatActivity {
    ProgressDialog pd;
    ImageView iv;
    TextView t1,t2,t3,t4,t5,t6,t7;
    SharedPreferences shp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        iv = (ImageView)findViewById(R.id.imageView);
        t1 = (TextView)findViewById(R.id.textView2);
        t2 = (TextView)findViewById(R.id.textView4);
        t3 = (TextView)findViewById(R.id.textView6);
        t4 = (TextView)findViewById(R.id.textView8);
        t5 = (TextView)findViewById(R.id.textView10);
        t6 = (TextView)findViewById(R.id.textView12);
        t7 = (TextView)findViewById(R.id.textView14);
        shp=getSharedPreferences("mypref",0);
            new profile.getprofile().execute();

    }

    class getprofile extends AsyncTask< Void,Void,Void>{
        String result,id;
        @Override
        protected void onPreExecute() {

            pd=new ProgressDialog(profile.this);
            pd.setMessage("Wait..");
            pd.setTitle("PMS");
            shp=getSharedPreferences("mypref",0);
            id = shp.getString("rid","");
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            result = W_Getprofile.getprofile(id);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pd.dismiss();
            StringTokenizer st=new StringTokenizer(result,"|");
            String id,name;
            id =  st.nextToken();
            name = st.nextToken();
            t1.setText(name);
            t2.setText(st.nextToken());
            t3.setText(st.nextToken());
            t4.setText(st.nextToken());
            t5.setText(st.nextToken());
            t6.setText(st.nextToken());
            String photo=st.nextToken();
            String gender=st.nextToken();

            if(gender.equals("1"))
            {
                t7.setText("Male");
            }
            else if(gender.equals("2"))
            {
                t7.setText("Female");
            }
            else
            {
                t7.setText("Others");
            }
            photo.trim();
            String path = "http://192.168.43.63:8080/PMS/"+photo;
            path=path.replace('\\', '/');
            path=path.replace(" ", "%20");
            path=path.trim();
            URL url;
            Log.i("photo",path);
            try
            {
                url = new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                myBitmap = Bitmap.createScaledBitmap(myBitmap,
                        100,100, true);
                iv.setImageBitmap(myBitmap);
            }
            catch(Exception e)
            {
                Log.i("Error",e.toString());

            }




        }
    }
}


