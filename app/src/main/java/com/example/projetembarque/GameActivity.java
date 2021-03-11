package com.example.projetembarque;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameActivity extends AppCompatActivity {

    private ResponseType responseType;
    private List<ButtonResponse> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.buttons = new ArrayList<ButtonResponse>();
        this.buttons.add(findViewById(R.id.game_buttonResponse1));
        this.buttons.add(findViewById(R.id.game_buttonResponse2));
        this.buttons.add(findViewById(R.id.game_buttonResponse3));
        this.buttons.add(findViewById(R.id.game_buttonResponse4));
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


    public void updateButtons(Response response) {
        // TODO Update the 4 response buttons with the new answers with a lambda expression
        for (int i = 0; i < this.buttons.size(); i++)
            this.updateButton(response.getAnswerByIndex(i), i, this.buttons.get(i));
    }

    /**
     * Update a button and put the id  and the answer's string in it
     * @param answer    The answer we have to put in the button
     * @param id        The id we have to put in the button
     * @param button    The button we have tu update
     */
    public void updateButton(Answer answer, int id, ButtonResponse button) {
        button.setResponseString(this.responseType.getResponse(answer));
        button.setId(id);
    }
    /*
    public void onClickUpdatePlayerList(View view) { // TODO: changer le onClick par un observer
        SharedPreferences playerList = getSharedPreferences("PLAYER_LIST", MODE_PRIVATE);
        Set<String> list2 = playerList.getStringSet("list", new HashSet<String>());
        ArrayList<String> list = new ArrayList<>();

        for (String name : list2) {
            list.add(name);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.simple_list_item, list);
        ListView playerListView = (ListView) findViewById(R.id.room_playerList);
        playerListView.setAdapter(adapter);
        this.removePlayer("Alexis");
    }*/
}