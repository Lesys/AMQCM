package com.example.projetembarque;

import java.util.ArrayList;
import java.util.List;

public class Response {
    /**
     * The list of possible answers, containing only 1 correct answer
     */
    private List<Answer> answers;
    /**
     * The index of the correct answer in the List (also the num of the button with the right answer)
     */
    private int answerId;

    public Response() {
        super();
        this.answers = new ArrayList<>(); // Initialisation of the list of answers
    }

    /**
     * Function returning the correct answer corresponding to the music played
     * @return  The correct answer
     */
    public Answer getRightAnswer() {
        return this.answers.get(this.answerId);
    }

    public int getAnswerId() {
        return this.answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    /**
     * Add an answer to the list of answers
     * @param answer    The answer to add to the list
     */
    public void addAnswer(Answer answer) {
        if (this.answers.size() < 4) // TODO Change 4 with a global variable
            this.answers.add(answer);
    }

    public Answer getAnswerByIndex(int index) {
        return this.answers.get(index);
    }
}
