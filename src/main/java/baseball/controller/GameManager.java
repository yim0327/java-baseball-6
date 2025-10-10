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
    private boolean gameOver;

    public GameManager(InputView inputView, OutputView outputView, BaseballGame game) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballGame = game;
    }

    public void playGame() {
        outputView.showGameStart();

        do {
            try {
                baseballGame.resetAnswer();
                playRound();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }

        } while (shouldRestart());
    }

    private void playRound() {
       do {
            try {
                List<Integer> guess = baseballGame.validateGuess(inputView.inputNumbers());
                Hint hint = baseballGame.judge(guess);

                outputView.printHint(hint);

                gameOver = handleWin(hint);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
       } while(!gameOver);
    }

    private boolean handleWin(Hint hint) {
        if (hint.isWin(hint)) {
            outputView.printGameOver();
            return true;
        }
        return false;
    }

    private boolean shouldRestart() {
        String restart = inputView.inputRestartNumber();
        if ("2".equals(restart)) { return false; }
        if (!"1".equals(restart)) { throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다."); }
        return true;
    }

}
