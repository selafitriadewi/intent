package com.selafitriadewi.implicitintent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        mWebsiteEditText = findViewById ( R.id.website_edittext );
        mLocationEditText = findViewById ( R.id.location_edittext );
    }

    public void openWebsite ( View view ) {
        String url = mWebsiteEditText.getText ( ).toString ( );
        Uri webpage = Uri.parse ( url );
        Intent intent = new Intent ( Intent.ACTION_VIEW , webpage );
        if (intent.resolveActivity ( getPackageManager ( ) ) != null) {
            startActivity ( intent );
        } else {
            Log.d ( "ImplicitIntens" , "Can't handle this intent!" );
        }
    }

    public void openLocation ( View view ) {
        String loc = mLocationEditText.getText ( ).toString ( );
        Uri addressUri = Uri.parse ( "geo:0,0?q=" + loc );
        Intent intent = new Intent ( Intent.ACTION_VIEW , addressUri );
        if (intent.resolveActivity ( getPackageManager ( ) ) != null) {
            startActivity ( intent );
        } else {
            Log.d ( "ImplicitIntens" , "Can't handle this intent!" );
        }
    }
}
