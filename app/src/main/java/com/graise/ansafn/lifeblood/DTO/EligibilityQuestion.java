package com.graise.ansafn.lifeblood.DTO;

import com.graise.ansafn.lifeblood.DonationRequest.Id;

public class EligibilityQuestion {
    private int no;
    private String question;
    private int nextQNo;

    public EligibilityQuestion(int no, String question, int nextQNo) {
        this.no = no;
        this.question = question;
        this.nextQNo = nextQNo;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getNextQNo() {
        return nextQNo;
    }

    public void setNextQNo(int nextQNo) {
        this.nextQNo = nextQNo;
    }
}
