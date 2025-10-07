package baseball.controller;

import baseball.service.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

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

    }
}
