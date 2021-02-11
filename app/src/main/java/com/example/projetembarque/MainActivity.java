package com.example.projetembarque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {

        Intent connectionIndent = new Intent(getApplicationContext(), ConnectionActivity.class);
        Intent createRoomIndent = new Intent(getApplicationContext(), RoomActivity.class);
        Intent profileIndent = new Intent(getApplicationContext(), ProfileActivity.class);


        startActivityForResult(connectionIndent, 1);
    }
}