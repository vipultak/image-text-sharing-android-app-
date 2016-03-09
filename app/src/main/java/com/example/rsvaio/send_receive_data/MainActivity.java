package com.example.rsvaio.send_receive_data;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button send,receive;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = (Button) findViewById(R.id.SendButton);

        receive = (Button)findViewById(R.id.ReceiveButton);

        send.setOnClickListener(this);

        receive.setOnClickListener(this);


        textView = (TextView) findViewById(R.id.ReceiveText);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.SendButton:{
                Intent intent = new Intent(MainActivity.this,Send_Data.class);
                startActivity(intent);
                break;
            }
            case R.id.ReceiveButton:{
                Intent intent = new Intent(MainActivity.this,Receive_Data.class);
                startActivity(intent);
                break;
            }


        }
    }

}
