package com.example.projetembarque.modele;

public class ResponseTypeTitle extends ResponseType {
    private static ResponseType instance = null;

    public ResponseTypeTitle() {
        super();
    }

    public String getResponse(Answer answer) {
        return answer.getTitle();
    }

    public static ResponseType getInstance() {
        if (ResponseTypeTitle.instance == null)
            ResponseTypeTitle.instance = new ResponseTypeTitle();

        return ResponseTypeTitle.instance;
    }

    @Override
    public String toString() {
        return "Title Type";
    }
}
