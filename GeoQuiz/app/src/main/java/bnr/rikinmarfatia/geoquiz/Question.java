package bnr.rikinmarfatia.geoquiz;

public class Question {

    private int questionTextResId;
    private boolean answerTrue;

    public Question(int questionTextResId, boolean answerTrue) {
        this.questionTextResId = questionTextResId;
        this.answerTrue = answerTrue;
    }

    public int getQuestionTextResId() {
        return questionTextResId;
    }

    public void setQuestionTextResId(int questionTextResId) {
        this.questionTextResId = questionTextResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
