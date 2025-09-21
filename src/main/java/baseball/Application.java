package baseball;

import baseball.domain.AnswerProvider;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AnswerProvider computer = new AnswerProvider();
        Player player = new Player();

        computer.setAnswer();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            List<Integer> ball = player.submittedNum(input);

        }

    }
}
