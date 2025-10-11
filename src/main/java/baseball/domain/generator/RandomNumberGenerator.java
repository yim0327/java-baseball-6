package baseball.domain.generator;

import baseball.domain.Ball;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    public int generate() {
        return Randoms.pickNumberInRange(Ball.MIN_DIGITS, Ball.MAX_DIGITS);
    }
}
