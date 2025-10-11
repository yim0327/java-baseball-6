package baseball.view;

import baseball.domain.Hint;

public class OutputView {

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printHint(Hint hint) {
        System.out.println(hint.toString());
    }

    public void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
