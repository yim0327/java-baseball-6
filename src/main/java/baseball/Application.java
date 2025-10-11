package baseball;

import baseball.controller.GameManager;
import baseball.domain.*;
import baseball.service.BaseballGame;
import baseball.domain.generator.NumberGenerator;
import baseball.domain.generator.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator generator = new RandomNumberGenerator();
        AnswerProvider computer = new AnswerProvider(generator);
        Player player = new Player();
        BaseballGame game = new BaseballGame(player, computer);
        GameManager manager = new GameManager(inputView, outputView, game);

        manager.playGame();
    }
}
