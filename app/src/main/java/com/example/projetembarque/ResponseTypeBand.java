package com.example.projetembarque;

public class ResponseTypeBand extends ResponseType {
    protected int id;
    protected String type;

    public ResponseTypeBand() {
        super();
    }

    public String getResponse(Answer answer) {
        return answer.getBand();
    }
}
