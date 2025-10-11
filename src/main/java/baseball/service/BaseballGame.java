package baseball.service;

import baseball.domain.*;

public class BaseballGame {
    private final AnswerProvider answerProvider;

    public BaseballGame(AnswerProvider answerProvider) {
        this.answerProvider = answerProvider;
    }

    public void resetAnswer() {
        answerProvider.setAnswer();
    }

    public Hint judge(Ball guess) {
        return answerProvider.judge(guess.getBallNumbers());
    }
}
