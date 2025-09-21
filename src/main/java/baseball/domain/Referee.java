package baseball.domain;

import java.util.List;

public class Referee {
    public Hint judge(List<Integer> guess, List<Integer> answer) {
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
