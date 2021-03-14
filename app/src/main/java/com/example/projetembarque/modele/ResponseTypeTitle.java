package com.example.projetembarque.modele;

public class ResponseTypeTitle extends ResponseType {
    protected int id;
    protected String type;

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
}
