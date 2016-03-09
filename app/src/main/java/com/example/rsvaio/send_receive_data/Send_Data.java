package com.example.rsvaio.send_receive_data;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.net.URI;

public class Send_Data extends AppCompatActivity implements View.OnClickListener{
    Button share,image;
    EditText edit,imageName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__data);
        share = (Button) findViewById(R.id.shareButton);
        image = (Button) findViewById(R.id.imageButton);
        imageName = (EditText) findViewById(R.id.imageName);
        edit = (EditText) findViewById(R.id.editText);
        share.setOnClickListener(this);
        image.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.shareButton:{
                String str = edit.getText().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, str);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
            }
            case R.id.imageButton:{
                String str = imageName.getText().toString();
                String imagePath = Environment.getExternalStorageDirectory()+ "/"+str+".jpg";
                File imageFileToShare = new File(imagePath);
                Uri uri = Uri.fromFile(imageFileToShare);
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_STREAM,uri);
                sendIntent.setType("image/*");
                startActivity(sendIntent);
            }
        }
    }
}
