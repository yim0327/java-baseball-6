package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.Hint;
import baseball.service.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

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
        outputView.printGameStart();

        do {
            baseballGame.resetAnswer();
            playRound();
        } while (!shouldRestart());
    }

    private void playRound() {
       do {
            try {
                Ball guess = Ball.from(inputView.inputNumbers());
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
        while(true) {
            try {
                return "2".equals(inputView.inputRestartNumber());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

}
