package com.example.projetembarque;

import org.json.JSONException;
import org.json.JSONObject;

public class API {

    int id_anim;
    Object obj;
    public API(Player []players, Object obj) throws InterruptedException {
        JSONObject data;
        this.obj = obj;
        for (int i = 0; i < players.length; i++) {
            String s_url = "https://api.jikan.moe/v3/user/" + players[i].getLoginMAL() + "";
            URLConnect link = new URLConnect(s_url, obj);
            link.start();
            link.join();
            data = link.getData();
        }
    }
    /*
     * getTitle return the Japaness title in romanji.
     * @throws getting back JSONException if data not declare
     */
    public int getId(JSONObject data) throws JSONException {
        return data.getInt("mal_id");
    }

    /*
     * getTitleJapanese return the Japanese style.
     * @throws getting back JSONException if data not declare
     */
    public String getTitleJapanese(JSONObject data) throws JSONException {
        return data.getString("title_japanese");
    }

    /*
     * getSynopsis return the synopsis for API
     * @throws getting back JSONException if data not declare
     */
    public String getSynopsis(JSONObject data) throws JSONException {
        return data.getString("synopsis");
    }

    /*
     * Method toString
     * Return Anim class to String
     */
    /*public String toString(){
        String back = "Bonjour";
        try {
            back = "Test" + this.getId() + ':' + this.getTitleJapanese();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return back;
    }*/
}