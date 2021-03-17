package com.example.projetembarque.modele;

public class ResponseTypeBand extends ResponseType {
    private static ResponseType instance = null;

    public ResponseTypeBand() {
        super();
    }

    public String getResponse(Answer answer) {
        return answer.getBand();
    }

    public static ResponseType getInstance() {
        if (ResponseTypeBand.instance == null)
            ResponseTypeBand.instance = new ResponseTypeBand();

        return ResponseTypeBand.instance;
    }

    @Override
    public String toString() {
        return "Band Type";
    }
}
