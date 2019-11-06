package com.example.playarea;



import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class PassSecondActivity extends AppCompatActivity {
    TextView txtpassvalue;
    Button btnpassvaluesecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_second);
        txtpassvalue=(TextView)findViewById(R.id.txtpassvaluesecond);
        txtpassvalue.setText(getIntent().getExtras().getString("value"));
        btnpassvaluesecond=(Button)findViewById(R.id.btnpassvaluesecond);
        btnpassvaluesecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ipasstwo=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(ipasstwo);
            }
        });
    }

}