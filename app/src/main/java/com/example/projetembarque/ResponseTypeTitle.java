package com.example.projetembarque;

public class ResponseTypeTitle extends ResponseType {
    protected int id;
    protected String type;

    public ResponseTypeTitle() {
        super();
    }

    public String getResponse(Answer answer) {
        return answer.getTitle();
    }
}
