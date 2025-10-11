package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Ball {
    public static final int MAX_DIGITS = 9, MIN_DIGITS = 1;
    public static final int DIGIT_LENGTH = 3;
    private final List<Integer> numbers;

    private Ball(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 사용자 입력용
    public static Ball from(String input) {
        List<Integer> numbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();

        validateNumbers(numbers);
        return new Ball(numbers);
    }

    // 내부(정답 생성)용
    public static Ball of(List<Integer> numbers) {
        validateNumbers(numbers);
        return new Ball(numbers);
    }

    public List<Integer> getBallNumbers() {
        return List.copyOf(numbers);
    }

    private static void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != DIGIT_LENGTH) {
            throw new IllegalArgumentException("숫자열 길이는 " + DIGIT_LENGTH + " 이어야 합니다.");
        }

        if (!numbers.stream().allMatch(n -> n >= MIN_DIGITS && n <= MAX_DIGITS)) {
            throw new IllegalArgumentException("모든 숫자는 " + MIN_DIGITS + "~"
                    + MAX_DIGITS + " 사이의 값이어야 합니다.");
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("모든 숫자가 서로 다른 숫자로 이루어져야 합니다.");
        }
    }

}
