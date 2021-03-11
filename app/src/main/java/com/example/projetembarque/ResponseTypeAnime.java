package com.example.projetembarque;

public class ResponseTypeAnime {
    protected int id;
    protected String type;

    public ResponseTypeAnime() {
        super();
    }

    public String getResponse(Answer answer) {
        return answer.getAnime();
    }
}
