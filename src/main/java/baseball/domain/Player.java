package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Player {
    private final NumberRules rules = new NumberRules();

    public List<Integer> submittedNum(String input) {
        List<Integer> parsedNum = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();

        rules.checkRules(parsedNum);

        return parsedNum;
    }
}
