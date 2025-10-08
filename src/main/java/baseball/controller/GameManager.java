package baseball.controller;

import baseball.domain.Hint;
import baseball.domain.NumberRules;
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
        showGameStart();

        while(true) {
            baseballGame.resetAnswer();

            while (true) {
                List<Integer> guess = baseballGame.validateGuess(getInput());
                Hint hint = baseballGame.judge(guess);
                showHint(hint);

                if (hint.isWin(hint)) {
                    showGameOver();
                    break;
                }
            }

            String restart = inputView.inputRestartNumber();
            if ("2".equals(restart)) { break; }
            if (!"1".equals(restart)) { throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다."); }
        }
    }

    private String getInput() {
        return inputView.inputNumbers();
    }

    private void showGameStart() {
        outputView.showGameStart();
    }

    private void showHint(Hint hint) {
        outputView.printHint(hint);
    }

    private void showGameOver() {
        outputView.printGameOver();
    }
}
