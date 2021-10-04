package baseball.domain;

public class Game {

	private final AnswerGenerator generator;

	private boolean playing;

	private String answer;

	private final Counter strikeCounter;

	private final Counter ballCounter;

	public Game(GameRule rule) {
		this.playing = false;
		this.generator = new AnswerGenerator(rule);
		this.strikeCounter = new StrikeCounter();
		this.ballCounter = new BallCounter();
	}

	public boolean isPlaying() {
		return playing;
	}

	public void start() {
		playing = true;
		answer = generator.generate();
	}

	public int countStrike(String input) throws IllegalAccessException {
		if (!playing) {
			throw new IllegalAccessException("아직 게임이 시작되지 않았습니다");
		}
		return strikeCounter.count(answer, input);
	}

	public int countBall(String input) throws IllegalAccessException {
		if (!playing) {
			throw new IllegalAccessException("아직 게임이 시작되지 않았습니다");
		}
		return ballCounter.count(answer, input);
	}

	public GameRecord play(String input) throws IllegalAccessException {
		int strikeCount = countStrike(input);
		int ballCount = countBall(input);

		if (strikeCount == 3) {
			endGame();
		}

		return new GameRecord(strikeCount, ballCount);
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	private void endGame() {
		playing = false;
	}
}
