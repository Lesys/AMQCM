package com.example.projetembarque;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameActivity extends AppCompatActivity {
    private ResponseType responseType;
    private Response response;
    private List<ButtonResponse> buttons;
    private int numberMusic;
    private int numberMaxPlayer;
    /**
     * Number of seconds a player has to answer
     */
    private int responseTime;

    private CountDownTimer timer = null;

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

    protected void onPostResume() {
        super.onPostResume();
        this.updateValues();
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

        this.updateButtons(this.response);

        this.updateListPlayer();

        this.updateValues();

        this.resetTimer();
    }

    private void updateValues() {
        this.takeNumberMaxPlayer();
        this.takeNumberMusic();
        this.takeResponseTime();
        this.takeResponseType();
    }


    private void takeValues() {
        SharedPreferences values = getSharedPreferences("PLAYER_LIST", MODE_PRIVATE);
        this.numberMusic = values.getInt("numberMusic", 20);
        this.numberMaxPlayer = values.getInt("numberMaxPlayer", 21);
        this.responseTime = values.getInt("responseTime", 22);
        String responseTypeString = values.getString("responseType", "");

        //((TextView) findViewById(R.id.game_test)).setText("Type: " + responseTypeString);
        switch (responseTypeString) {
            case "Band": this.responseType =  ResponseTypeBand.getInstance();
                break;
            case "Title": this.responseType =  ResponseTypeTitle.getInstance();
                break;
            case "Anime":
            default: this.responseType =  ResponseTypeAnime.getInstance();
        }
    }

    private void takeNumberMusic() {
        SharedPreferences numberMusic = getSharedPreferences("PLAYER_LIST", MODE_PRIVATE);
        this.numberMusic = numberMusic.getInt("numberMusic", 10);
    }

    private void takeNumberMaxPlayer() {
        SharedPreferences numberMaxPlayer = getSharedPreferences("PLAYER_LIST", MODE_PRIVATE);
        this.numberMaxPlayer = numberMaxPlayer.getInt("numberMaxPlayer", 4);
    }

    private void takeResponseTime() {
        SharedPreferences responseTime = getSharedPreferences("PLAYER_LIST", MODE_PRIVATE);
        this.responseTime = responseTime.getInt("responseTime", 20);
    }

    private void takeResponseType() {
        SharedPreferences responseType = getSharedPreferences("PLAYER_LIST", MODE_PRIVATE);
        String responseTypeString = responseType.getString("responseType", "Anime");

        //((TextView) findViewById(R.id.game_test)).setText("Type: " + responseTypeString);
        switch (responseTypeString) {
            case "Band": this.responseType =  ResponseTypeBand.getInstance();
                break;
            case "Title": this.responseType =  ResponseTypeTitle.getInstance();
                break;
            case "Anime":
            default: this.responseType =  ResponseTypeAnime.getInstance();
        }
    }

    private void resetTimer() {
        if (this.timer != null)
            this.timer.cancel();
        this.timer = new CountDownTimer(this.responseTime * 1000, 1000) {
            @Override
            public void onTick(long time) {
                ((TextView) findViewById(R.id.game_timerDisplay)).setText("Remaining time: " + time / 1000);
            }

            @Override
            public void onFinish() {
                ((TextView) findViewById(R.id.game_timerDisplay)).setText("Showing answer...");
            }
        }.start();
    }

    private void stopAnswers() {
    }

    private void playNextMusic() {
        this.resetTimer();

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
        this.resetTimer();
    }
}