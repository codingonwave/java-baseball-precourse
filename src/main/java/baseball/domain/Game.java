package baseball.domain;

import java.util.Arrays;
import java.util.List;

public class Game {

    private final GameRule rule;

    private final AnswerGenerator generator;

    private boolean playing;

    private String answer;

    public Game(GameRule rule) {
        this.rule = rule;
        this.playing = false;
        this.generator = new AnswerGenerator(rule);
    }

    public boolean isPlaying() {
        return playing;
    }

    public void start() {
        playing = true;
        answer = generator.generate();
    }

    public int countStrike(String input) throws IllegalAccessException {
        if (!playing) throw new IllegalAccessException("아직 게임이 시작되지 않았습니다");

        List<String> inputNumbers = splitToNumberList(input);
        List<String> answers = splitToNumberList(answer);

        int strike = 0;

        for (int index = 0; index < inputNumbers.size(); index++) {
            strike += isStrike(inputNumbers.get(index), answers.get(index));
        }

        return strike;
    }

    public int countBall(String input) throws IllegalAccessException {
        if (!playing) throw new IllegalAccessException("아직 게임이 시작되지 않았습니다");

        List<String> inputNumbers = splitToNumberList(input);
        List<String> answers = splitToNumberList(answer);

        int ball = 0;

        for (int index = 0; index < inputNumbers.size(); index++) {
            ball += isBall(inputNumbers.get(index), answers.get(index));
        }

        return ball;
    }

    public String getAnswer() {
        return answer;
    }

    private List<String> splitToNumberList(String input) {
        String[] split = input.split("");
        return Arrays.asList(split);
    }

    private int isStrike(String ithInput, String ithAnswer) {
        if (ithInput.equals(ithAnswer)) return 1;

        return 0;
    }

    private int isBall(String ithInput, String ithAnswer) {
        if (!ithInput.equals(ithAnswer) && answer.contains(ithInput)) return 1;

        return 0;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
