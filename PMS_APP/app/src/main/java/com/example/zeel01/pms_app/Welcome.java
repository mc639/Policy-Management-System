package com.example.zeel01.pms_app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.TextViewCompat;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Welcome extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences shp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

         shp=getSharedPreferences("mypref",0);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ImageView iv=(ImageView)navigationView.getHeaderView(0).findViewById(R.id.imageView);
        TextView tv=(TextView)navigationView.getHeaderView(0).findViewById(R.id.textView);
        tv.setText(shp.getString("name",""));
        String photo=shp.getString("photo","");


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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_slideshow) {
            startActivity(new Intent(Welcome.this,Purchased_policy.class));

        } else if (id == R.id.nav_policy) {
            startActivity(new Intent(Welcome.this,Policy.class));

        }
        else if (id == R.id.nav_profile) {
            startActivity(new Intent(Welcome.this,profile.class));

        }
        else if (id == R.id.nav_cp) {
            startActivity(new Intent(Welcome.this,Change_password.class));

        } else if (id == R.id.nav_logout) {
            SharedPreferences.Editor ed=shp.edit();
            ed.clear();
            ed.commit();
            Intent i=new Intent(Welcome.this, MainActivity.class);
            startActivity(i);
            finish();
        }
        else if(id== R.id.nav_wishlist){
            startActivity(new Intent(Welcome.this,wishlist.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}

