package com.example.projetembarque;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.SharedPreferences;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        addPlayer("Snalts");
        addPlayer("Lesys");
        addPlayer("Yann");
        addPlayer("Logic");
        //fillSpinerResponseType();
    }

/*
    public void fillSpinerResponseType() {
        Spinner spinner = (Spinner) findViewById(R.id.room_reponseType);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.array_responseType, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }*/

    public void addPlayer(String playerName) {
        SharedPreferences playerList = getSharedPreferences("PLAYER_LIST", MODE_PRIVATE);
        SharedPreferences.Editor playerListEditor = playerList.edit();

        Set<String> list = playerList.getStringSet("list", new HashSet<String>());

        //list.addAll(playerList.getStringSet("list", null));
        list.add(playerName);

        /*System.out.println(list.toArray());*/
        playerListEditor.putStringSet("list", list);
        playerListEditor.commit();

        //this.onClickUpdatePlayerList();
    }

    public void removePlayer(String playerName) {
        SharedPreferences playerList = getSharedPreferences("PLAYER_LIST", MODE_PRIVATE);
        SharedPreferences.Editor playerListEditor = playerList.edit();

        Set<String> list = playerList.getStringSet("list", null);
        //list.addAll(playerList.getStringSet("list", null));
        try {
            list.remove("Snalts");
            /*System.out.println(list.toArray());*/
            playerListEditor.putStringSet("list", list);
            playerListEditor.commit();
        } catch (Exception e) {

        }
    }

    public void onClickUpdatePlayerList(View view) { // TODO: changer le onClick par un observer
        SharedPreferences playerList = getSharedPreferences("PLAYER_LIST", MODE_PRIVATE);
        Set<String> list2 = playerList.getStringSet("list", new HashSet<String>());
        ArrayList<String> list = new ArrayList<>();

        for (String name : list2) {
            list.add(name);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.simple_list_item, list);
        /*for (String name: list) {
           TextView text = new TextView(this);
           text.setText(name);
           adapter.add(text);
        }*/

        ListView playerListView = (ListView) findViewById(R.id.room_playerList);
        playerListView.setAdapter(adapter);
        this.removePlayer("Alexis");
    }
}