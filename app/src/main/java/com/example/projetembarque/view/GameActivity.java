package com.example.projetembarque.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projetembarque.modele.Answer;
import com.example.projetembarque.R;
import com.example.projetembarque.modele.CountDownTimerPerso;
import com.example.projetembarque.modele.Response;
import com.example.projetembarque.modele.ResponseType;
import com.example.projetembarque.modele.ResponseTypeAnime;
import com.example.projetembarque.modele.ResponseTypeBand;
import com.example.projetembarque.modele.ResponseTypeTitle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GameActivity extends AppCompatActivity {
    private ResponseType responseType;
    private Response response;
    private List<ButtonResponse> buttons;
    private int numberMusic;
    private int numberMusicPlayed;
    private int numberMaxPlayer;
    private int score;

    private static List<Response> listResponses; // TODO DELETE
    /**
     * Number of seconds a player has to answer
     */
    private int responseTime;

    private CountDownTimer timer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        GameActivity.initResponses();
        this.numberMusicPlayed = 1;
        this.score = 0;
        this.updateValues();
        this.buttons = new ArrayList<>();
        this.buttons.add(findViewById(R.id.game_buttonResponse1));
        this.buttons.add(findViewById(R.id.game_buttonResponse2));
        this.buttons.add(findViewById(R.id.game_buttonResponse3));
        this.buttons.add(findViewById(R.id.game_buttonResponse4));
        this.test();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.updateValues();
    }

    private void updateNbMusicPlayed() {
        ((TextView) findViewById(R.id.game_nbMusics)).setText(this.numberMusicPlayed + " / " + this.numberMusic);
        ((TextView) findViewById(R.id.game_score)).setText("Score: " + this.score);
    }

    public void updateButtons() {
        // TODO Update the 4 response buttons with the new answers with a lambda expression
        for (int i = 0; i < this.buttons.size(); i++)
            this.updateButton(this.response.getAnswerByIndex(i), i, this.buttons.get(i));


        this.buttons.forEach(button -> button.setBackgroundColor(getResources().getColor(R.color.button_response_background)));

        this.changeButtonClickable(true);
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

    private void changeButtonClickable(boolean bool) {
        this.buttons.forEach(button -> button.setEnabled(bool));
    }

    private void test() {
        Answer a = new Answer("No Game No Life", "Suzuki Konomi", "This Game");
        Answer b = new Answer("No Game No Life Movie", "Suzuki Konomi", "There is a reason");
        Answer c = new Answer("Sword Art Online", "LiSA", "crossing field");
        Answer d = new Answer("Sword Art Online II", "Tomatsu Haruka", "courage");

        /*
        GameActivity.responseType = new ResponseTypeTitle();
        this.response = new Response();
        this.response.addAnswer(a);
        this.response.addAnswer(b);
        this.response.addAnswer(c);
        this.response.addAnswer(d);*/

        //this.updateValues();

        this.response = this.getNextResponse();


        this.response.setAnswerId(1);

        this.updateButtons();

        this.updateListPlayer();

        this.resetTimer();
    }

    private void updateValues() {
        this.takeNumberMaxPlayer();
        this.takeNumberMusic();
        this.takeResponseTime();
        this.takeResponseType();
    }

    private Response getNextResponse() {
        int random = new Random().nextInt(GameActivity.listResponses.size());
        //System.out.println("Taille: " + GameActivity.listResponses.size() + ", random: " + random);
        return GameActivity.listResponses.get(random);
    }

    private static void initResponses() {
        Answer a = new Answer("No Game No Life", "Suzuki Konomi 2", "This Game");
        Answer b = new Answer("No Game No Life Movie", "Suzuki Konomi", "There is a reason");
        Answer c = new Answer("Sword Art Online", "LiSA", "crossing field");
        Answer d = new Answer("Sword Art Online II", "Tomatsu Haruka", "courage");


        GameActivity.listResponses = new ArrayList<>();

        for (int i = 0; i < 4; i++)
            GameActivity.listResponses.add(new Response());

        for (int i = 0; i < 4; i++) {
            Response r = GameActivity.listResponses.get(i);
            r.addAnswer(a);
            r.addAnswer(b);
            r.addAnswer(c);
            r.addAnswer(d);
            r.setAnswerId(i);
        }

        //System.out.println("Response 3: " + GameActivity.listResponses.get(3));
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
        String responseTypeString = responseType.getString("responseType", "");

        switch (responseTypeString) {
            case "Groupe":
            case "Band": this.responseType =  ResponseTypeBand.getInstance(); System.out.println("Pouet Band");
                break;
            case "Titre":
            case "Title": this.responseType =  ResponseTypeTitle.getInstance(); System.out.println("Test Title");
                break;
            case "Anime":
            default: this.responseType = ResponseTypeAnime.getInstance(); System.out.println("Allo default");
        }

    }

    private void resetTimer() {
        this.updateNbMusicPlayed();
        this.stopTimer();
        this.timer = new CountDownTimerPerso(this.responseTime * 1000, 1000, this) {
            @Override
            public void onTick(long time) {
                ((TextView) findViewById(R.id.game_timerDisplay)).setText("Remaining time: " + time / 1000);
            }

            @Override
            public void onFinish() {
                ((TextView) findViewById(R.id.game_timerDisplay)).setText("Showing answer...");

                gameActivity.stopAnswers();
                gameActivity.buttons.get(gameActivity.response.getAnswerId()).setBackgroundColor(getResources().getColor(R.color.right_answer));
            }
        }.start();
    }

    private void showingAnswerTimer() {
        this.stopTimer();
        this.timer = new CountDownTimerPerso(5 * 1000, 1000, this) {
            @Override
            public void onTick(long time) {
                if (gameActivity.numberMusicPlayed != gameActivity.numberMusic)
                    ((TextView) findViewById(R.id.game_timerDisplay)).setText("Next music plays in: " + time / 1000);
                else
                    ((TextView) findViewById(R.id.game_timerDisplay)).setText("End of the game in: " + time / 1000);
            }

            @Override
            public void onFinish() {
                // If there is still some music to play
                if (gameActivity.numberMusicPlayed != gameActivity.numberMusic) {
                    ((TextView) findViewById(R.id.game_timerDisplay)).setText("Music loading...");

                    gameActivity.nextMusic();
                }
                // If all music were played
                else {
                    finish();
                }
            }
        }.start();
    }


    private void stopTimer() {
        if (this.timer != null)
            this.timer.cancel();
    }
    private void stopAnswers() {
        this.stopTimer();

        this.changeButtonClickable(false);

        this.showingAnswerTimer();
    }

    private void playNextMusic() {
        this.resetTimer();

    }

    public void nextMusic() {
        this.numberMusicPlayed++;

        this.response = this.getNextResponse();

        this.updateButtons();

        this.playNextMusic();
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

        if (this.buttons.get(this.response.getAnswerId()).equals(buttonResponse))
            this.score++;
        this.stopAnswers();
    }
}