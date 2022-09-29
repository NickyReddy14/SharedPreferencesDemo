package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    TextView name,email;
    Button bn;

    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        name=(TextView) findViewById(R.id.t1);
        email=(TextView) findViewById(R.id.t2);
        bn=(Button)findViewById(R.id.button);

        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String n=sharedPreferences.getString(KEY_NAME,null);
        String e=sharedPreferences.getString(KEY_EMAIL,null);
        if(n!=null ||e!=null)
        {
            name.setText("Name: "+n);
            email.setText("Mail ID: "+e);
        }
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(HomeActivity.this,"Logout successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}