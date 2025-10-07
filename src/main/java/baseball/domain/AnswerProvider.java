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

    // 정답 생성
    public void setAnswer() {
        answer.clear(); // 재시작용 리스트 비우기
        while (answer.size() < NumberRules.DIGIT_LENGTH) {
            int randomNumber = generator.generate();
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        rules.checkRules(answer);
    }

    // 정답 제공
    public List<Integer> getAnswer() {
        return List.copyOf(answer);
    }
}
