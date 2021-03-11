package com.example.projetembarque;

public abstract class ResponseType {
    protected int id;
    protected String type;

    public ResponseType() {
        super();
    }

    public abstract String getResponse(Answer answer);
}
