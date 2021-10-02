package baseball.domain;

public class GameRecord {

    private int strike;

    private int ball;

    public GameRecord(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
