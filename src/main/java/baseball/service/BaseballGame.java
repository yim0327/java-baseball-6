package baseball.service;

import baseball.domain.*;

import java.util.List;

public class BaseballGame {
    private final Player player;
    private final Referee referee;
    private final AnswerProvider answerProvider;

    public BaseballGame(Player player, AnswerProvider answerProvider, Referee referee) {
        this.player = player;
        this.answerProvider = answerProvider;
        this.referee = referee;
    }

    public void resetAnswer() {
        answerProvider.setAnswer();
    }

    public List<Integer> validateGuess(String input) {
        return player.validateNumbers(input);
    }

    public Hint judge(List<Integer> guess) {
        return referee.judge(guess, answerProvider.getAnswer());
    }
}
