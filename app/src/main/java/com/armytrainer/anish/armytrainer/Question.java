package com.armytrainer.anish.armytrainer;

/**
 * Created by Praveen on 2/25/2015.
 */
public class Question {
    private int qno;
    private String qText;
    private String qChoice1;
    private String qChoice2;
    private String qChoice3;
    private String qChoice4;
    private String qAnswer;

    public Question(int qno, String qText, String qChoice1, String qChoice2, String qChoice3, String qChoice4, String qAnswer) {
        this.qno = qno;
        this.qText = qText;
        this.qChoice1 = qChoice1;
        this.qChoice2 = qChoice2;
        this.qChoice3 = qChoice3;
        this.qChoice4 = qChoice4;
        this.qAnswer = qAnswer;
    }



    public void setQno(int qno) {
        this.qno = qno;
    }

    public int getQno() {
        return qno;
    }

    public String getqText() {
        return qText;
    }

    public String getqChoice1() {
        return qChoice1;
    }

    public String getqChoice2() {
        return qChoice2;
    }

    public String getqChoice3() {
        return qChoice3;
    }

    public String getqChoice4() {
        return qChoice4;
    }

    public String getqAnswer() {
        return qAnswer;
    }
}
