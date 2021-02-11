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

    public void onClickConnect(View view) {
        Intent connectionIndent = new Intent(getApplicationContext(), ConnectionActivity.class);
        startActivityForResult(connectionIndent, 1);
    }

    public void onClickRoom(View view) {
        Intent createRoomIndent = new Intent(getApplicationContext(), RoomActivity.class);
        startActivityForResult(createRoomIndent, 1);
    }

    public void onClickProfile(View view) {
        Intent profileIndent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult(profileIndent, 1);
    }

}