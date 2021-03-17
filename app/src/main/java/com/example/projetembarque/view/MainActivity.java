    package com.example.projetembarque.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.projetembarque.R;
import com.example.projetembarque.controler.Registration;

import java.sql.SQLException;

    public class MainActivity extends AppCompatActivity {

    //TODO : Condition pour afficher soit le bouton de connexion, soit le bouton de profil

    public Object obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*this.obj = new Object();

        try {
            System.out.println("Main Activity");

            Registration r = new Registration(obj, "test", "String password", "String loginMAL");
        } catch (ClassNotFoundException e) {
            System.out.println("Exception ClassNotFound");
            e.printStackTrace();
        } catch (SQLException throwables) {
            System.out.println("Exception SQLException");
            throwables.printStackTrace();
        }*/

    }

    public void onClickConnect(View view) {
        Intent connectionIndent = new Intent(getApplicationContext(), ConnectionActivity.class);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.pop_up_login, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    public void onClickJoin(View view) {
        Intent connectionIndent = new Intent(getApplicationContext(), ConnectionActivity.class);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.pop_up_join, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
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