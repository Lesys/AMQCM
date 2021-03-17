package com.example.projetembarque.modele;

public class ResponseTypeAnime extends ResponseType {
    private static ResponseType instance = null;
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

    @Override
    public String toString() {
        return "Anime Type";
    }
}
