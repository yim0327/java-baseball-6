package baseball;

import baseball.domain.*;
import baseball.domain.generator.NumberGenerator;
import baseball.domain.generator.RandomNumberGenerator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        AnswerProvider computer = new AnswerProvider(generator);
        Player player = new Player();
        Referee referee = new Referee();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            computer.setAnswer();

            while (true) {
                System.out.println("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                List<Integer> guess = player.validateNumbers(input);

                Hint hint = referee.judge(guess, computer.getAnswer());
                System.out.println(hint);

                if (hint.getStrike() ==  NumberRules.DIGIT_LENGTH) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restart = Console.readLine();
            if (restart.equals("2")) { break; }
            if (!restart.equals("1")) { throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다."); }
        }
    }
}
