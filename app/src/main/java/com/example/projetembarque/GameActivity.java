package com.example.projetembarque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameActivity extends AppCompatActivity {
    private ResponseType responseType;
    private Response response;
    private List<ButtonResponse> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.buttons = new ArrayList<>();
        this.buttons.add(findViewById(R.id.game_buttonResponse1));
        this.buttons.add(findViewById(R.id.game_buttonResponse2));
        this.buttons.add(findViewById(R.id.game_buttonResponse3));
        this.buttons.add(findViewById(R.id.game_buttonResponse4));
        this.test();
    }

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

    private void test() {
        Answer a = new Answer("No Game No Life", "Suzuki Konomi", "This Game");
        Answer b = new Answer("No Game No Life Movie", "Suzuki Konomi", "There is a reason");
        Answer c = new Answer("Sword Art Online", "LiSA", "crossing field");
        Answer d = new Answer("Sword Art Online II", "Tomatsu Haruka", "courage");

        this.responseType = new ResponseTypeTitle();
        this.response = new Response();
        this.response.addAnswer(a);
        this.response.addAnswer(b);
        this.response.addAnswer(c);
        this.response.addAnswer(d);

        this.response.setAnswerId(1);

        updateButtons(this.response);

        this.updateListPlayer();
    }

    private void updateListPlayer() {
        SharedPreferences playerList = getSharedPreferences("PLAYER_LIST", MODE_PRIVATE);
        Set<String> list2 = playerList.getStringSet("list", new HashSet<String>());
        ArrayList<String> list = new ArrayList<>();

        for (String name : list2) {
            list.add(name);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.simple_list_item, list);

        ListView playerListView = (ListView) findViewById(R.id.game_playerList);
        playerListView.setAdapter(adapter);
    }

    public void onClickButtonResponse(View view) {
        ButtonResponse buttonResponse = (ButtonResponse) findViewById(view.getId());
        buttonResponse.setBackgroundColor(getResources().getColor(R.color.wrong_answer));
        this.buttons.get(this.response.getAnswerId()).setBackgroundColor(getResources().getColor(R.color.right_answer));

    }
}