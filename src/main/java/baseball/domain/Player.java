package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Player {
    private final NumberRules rules = new NumberRules();

    public List<Integer> validateNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();

        rules.checkRules(numbers);

        return numbers;
    }
}
