package com.example.projetembarque;

public class ResponseTypeAnime extends ResponseType {
    protected ResponseTypeAnime() {
        super();
    }

    public String getResponse(Answer answer) {
        return answer.getAnime();
    }

    public static ResponseType getInstance() {
        if (ResponseTypeAnime.instance == null)
            ResponseTypeAnime.instance = new ResponseTypeAnime();

        return ResponseTypeAnime.instance;
    }
}
