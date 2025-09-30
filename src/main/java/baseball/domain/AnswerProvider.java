package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class AnswerProvider {
    private final List<Integer> answer = new ArrayList<>();
    private final NumberRules rules = new NumberRules();

    // 정답 생성
    public void setAnswer() {
        answer.clear(); // 재시작용 리스트 비우기
        while (answer.size() < NumberRules.DIGIT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(NumberRules.MIN_DIGITS,
                    NumberRules.MAX_DIGITS);
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
