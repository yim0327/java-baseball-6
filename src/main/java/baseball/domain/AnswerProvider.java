package baseball.domain;

import baseball.domain.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class AnswerProvider {
    private final NumberGenerator generator;
    private final List<Integer> answer = new ArrayList<>();
    private final NumberRules rules = new NumberRules();

    public AnswerProvider(NumberGenerator generator) {
        this.generator = generator;
    }

    public void setAnswer() {
        answer.clear();
        while (answer.size() < NumberRules.DIGIT_LENGTH) {
            int randomNumber = generator.generate();
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        rules.checkRules(answer);
    }

    public List<Integer> getAnswer() {
        return List.copyOf(answer);
    }

    public Hint judge(List<Integer> guess) {
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < guess.size(); i++) {
            int tmp = guess.get(i);

            if(tmp == answer.get(i)) { strike++; }
            else if(answer.contains(tmp)) { ball++; }
        }

        return new Hint(strike, ball);
    }
}
