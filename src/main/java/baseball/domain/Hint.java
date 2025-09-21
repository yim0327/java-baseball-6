package baseball.domain;

public class Hint {
    private final int strike;
    private final int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    // main 출력용 toString 메서드
    @Override
    public String toString() {
        if (strike == 0 && ball == 0) { return "낫싱"; }

        String b = ball > 0 ? ball + "볼" : "";
        String s = strike > 0 ? strike + "스트라이크" : "";
        return (b + " " + s).trim();
    }
}