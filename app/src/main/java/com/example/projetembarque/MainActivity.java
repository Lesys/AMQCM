package com.example.projetembarque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickPopup(View view) {
        String message = ((TextView)findViewById(R.id.inputTextName)).getText().toString() + ((TextView)findViewById(R.id.inputTextLastName)).getText().toString();
        Toast.makeText(view.getContext(),message,Toast.LENGTH_LONG).show();
    }
}