package baseball.service;

import baseball.domain.*;

import java.util.List;

public class BaseballGame {
    private final Player player;
    private final AnswerProvider answerProvider;

    public BaseballGame(Player player, AnswerProvider answerProvider) {
        this.player = player;
        this.answerProvider = answerProvider;
    }

    public void resetAnswer() {
        answerProvider.setAnswer();
    }

    public List<Integer> validateGuess(String input) {
        return player.validateNumbers(input);
    }

    public Hint judge(List<Integer> guess) {
        return answerProvider.judge(guess);
    }
}
