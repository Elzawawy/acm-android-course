package com.bignerdranchguide.java.geoquiz.Model;

public class Question {

    private String questionText;
    private Boolean questionAnswer;

    public Question(String questionText, Boolean questionAnswer) {
        this.questionText = questionText;
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Boolean getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(Boolean questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}
