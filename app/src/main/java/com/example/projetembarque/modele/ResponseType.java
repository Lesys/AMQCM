package com.example.projetembarque.modele;

public class ResponseType {
    protected int id;
    protected String type;
    private static ResponseType instance = null;

    protected ResponseType() {
        super();
    }

    public String getResponse(Answer answer) {
        return "";
    }
    public static ResponseType getInstance() {
        if (ResponseType.instance == null)
            ResponseType.instance = new ResponseType();

        return ResponseType.instance;
    }

    public String toString() {
        return this.getClass().toString();
    }
}
