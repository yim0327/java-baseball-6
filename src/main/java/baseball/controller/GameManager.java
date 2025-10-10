package baseball.controller;

import baseball.domain.Hint;
import baseball.service.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballGame baseballGame;

    public GameManager(InputView inputView, OutputView outputView, BaseballGame game) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballGame = game;
    }

    public void playGame() {
        outputView.showGameStart();

        while(true) {
            baseballGame.resetAnswer();
            playRound();
            if (!shouldRestart()) break;
        }
    }

    private void playRound() {
        while (true) {
            try {
                List<Integer> guess = baseballGame.validateGuess(inputView.inputNumbers());
                Hint hint = baseballGame.judge(guess);

                outputView.printHint(hint);

                if (hint.isWin(hint)) {
                    outputView.printGameOver();
                    break;
                }
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private boolean shouldRestart() {
        String restart = inputView.inputRestartNumber();
        if ("2".equals(restart)) { return false; }
        if (!"1".equals(restart)) { throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다."); }
        return true;
    }

}
