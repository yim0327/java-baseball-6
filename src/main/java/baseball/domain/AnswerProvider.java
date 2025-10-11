package baseball.domain;

import baseball.domain.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class AnswerProvider {
    private final NumberGenerator generator;
    private Ball ball;

    public AnswerProvider(NumberGenerator generator) {
        this.generator = generator;
    }

    public void setAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < Ball.DIGIT_LENGTH) {
            int randomNumber = generator.generate();
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
         ball = Ball.of(answer);
    }

    public List<Integer> getAnswerNumbers() {
        return ball.getBallNumbers();
    }

    public Hint judge(List<Integer> guess) {
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < guess.size(); i++) {
            int tmp = guess.get(i);

            if(tmp == getAnswerNumbers().get(i)) { strike++; }
            else if(getAnswerNumbers().contains(tmp)) { ball++; }
        }

        return new Hint(strike, ball);
    }
}
