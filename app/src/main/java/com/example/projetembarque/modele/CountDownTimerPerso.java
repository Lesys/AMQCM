package com.example.projetembarque.modele;

import android.os.CountDownTimer;

import com.example.projetembarque.view.GameActivity;

public class CountDownTimerPerso extends CountDownTimer {
    public GameActivity gameActivity;
    public CountDownTimerPerso(long millisInFuture, long countDownInterval, GameActivity gameActivity) {
        super(millisInFuture, countDownInterval);
        this.gameActivity = gameActivity;
    }

    @Override
    public void onTick(long l) {

    }

    @Override
    public void onFinish() {

    }
}
