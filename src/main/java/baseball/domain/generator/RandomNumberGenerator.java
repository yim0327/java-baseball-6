package baseball.domain.generator;

import baseball.domain.NumberRules;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    public int generate() {
        return Randoms.pickNumberInRange(NumberRules.MIN_DIGITS, NumberRules.MAX_DIGITS);
    }
}
