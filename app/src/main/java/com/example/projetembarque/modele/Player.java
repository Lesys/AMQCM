package com.example.projetembarque.modele;

import com.example.projetembarque.controler.API;

public class Player {
    private String login;
    private String loginMAL;
    private int score;
    private Object obj;
    private API api;

    public Player(String login, String loginMAL, Object obj) {
        this.login = login;
        this.loginMAL = loginMAL;
        this.obj = obj;
    }

    /**
     * Sends the id of the answer the Player choose
     * @param id    id of the answer the Player choose
     */
    public void giveAnswer(int id) { //TODO : send the selected id to the response

    }

    public String getLoginMAL() {
        return loginMAL;
    }

    /**
     * When a player scores, he is granted with +1 score (will be more or less with different game type)
     */
    public void scored() {
        this.score++;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setLoginMAL(String loginMAL) {
        this.loginMAL = loginMAL;
    }
}
