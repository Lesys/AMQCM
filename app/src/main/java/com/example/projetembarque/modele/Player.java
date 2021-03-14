package com.example.projetembarque.modele;

public class Player {
    private String login;
    private String loginMAL;
    private int score;

    public Player(String login) {
        this.login = login;
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
}
