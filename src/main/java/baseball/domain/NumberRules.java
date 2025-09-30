package baseball.domain;

import java.util.List;

public class NumberRules {
    public static final int MAX_DIGITS = 9, MIN_DIGITS = 1;
    public static final int DIGIT_LENGTH = 3;

    // 검증 로직 제공
    public void checkRules(List<Integer> numbers) {
        // 길이 검증
        if (numbers.size() != DIGIT_LENGTH) {
            throw new IllegalArgumentException("숫자열 길이는 "+DIGIT_LENGTH+" 이어야 합니다.");
        }

        // 범위 검증
        if (!numbers.stream().allMatch(n -> n >= MIN_DIGITS && n <= MAX_DIGITS)) {
            throw new IllegalArgumentException("모든 숫자는 " + MIN_DIGITS + "~"
                    + MAX_DIGITS + " 사이의 값이어야 합니다.");
        }

        // 중복 검증
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("모든 숫자가 서로 다른 숫자로 이루어져야 합니다.");
        }
    }
}