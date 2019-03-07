package com.e.task7march;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user, pass;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        btn= findViewById(R.id.login);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("com.example.task7march", MODE_PRIVATE);
                String s_user=sp.getString("user", "user");
                String s_pass=sp.getString("pass", "any");

                if(s_user.equals(user.getText().toString()) && s_pass.equals(pass.getText().toString()))
                    startActivity(new Intent(MainActivity.this, Success.class));
                else
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("com.e.task7march", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user", "shivank.chauhan_mca18@gla.ac.in");
        editor.putString("pass", "12345");
        editor.apply();

    }
}
