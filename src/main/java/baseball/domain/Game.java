package baseball.domain;

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

}
