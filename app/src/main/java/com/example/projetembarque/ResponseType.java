package com.example.projetembarque;

public abstract class ResponseType {
    protected int id;
    protected String type;

    public ResponseType() {
        super();
    }

    public Answer getResponse(Response rep) {
        return new Answer(); // TODO
    }
}
