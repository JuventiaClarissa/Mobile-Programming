package com.example.fooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class location extends AppCompatActivity implements IBaseGpsListener {

    private static final int PERMISSION_LOCATION = 1000;

    TextView tv_location;
    Button locationBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_location);

        tv_location = findViewById(R.id.tv_location);
        locationBtn = findViewById(R.id.locationBtn);



        locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check for location permission
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M &&
                        checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                                != PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_LOCATION);
                } else{
                    showLocation();
                }
            }
        });


    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == PERMISSION_LOCATION){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                showLocation();
            } else{
                Toast.makeText(this, "Permission not granted!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @SuppressLint("MissingPermission")
    private void showLocation(){
        LocationManager locationMangaer = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // check if gps enable
        if(locationMangaer.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            //start locating
            tv_location.setText("Loading location...");
            locationMangaer.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
        }else{
            // enable gps
            Toast.makeText(this, "Enabled GPS", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    }

        // show Location as String
    private String hereLocation(Location location){
        return "Lat: " + location.getLatitude() +  "\nLon: " + location.getLatitude();
    }

    @Override
    public void onLocationChanged(Location location) {
        // update location
        tv_location.setText(hereLocation(location));
    }

    @Override
    public void onProviderDisabled(String provider) {
        // empty
    }

    @Override
    public void onProviderEnabled(String provider) {
        // empty
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // empty
    }

    @Override
    public void onGpsStatusChanged(int event) {
        // empty
    }
}