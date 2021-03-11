package com.example.projetembarque;

public class Answer {
    private String anime;
    private String band;
    private String title;

    public Answer(String anime, String band, String title) {
        this.anime = anime;
        this.band = band;
        this.title = title;
    }

    public String getAnime() {
        return this.anime;
    }

    public String getBand() {
        return this.band;
    }

    public String getTitle() {
        return this.title;
    }
}
