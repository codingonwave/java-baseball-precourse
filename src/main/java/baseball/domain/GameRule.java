package baseball.domain;

public class GameRule {

	private final int length;

	private final int from;

	private final int to;

	public GameRule(int length, int from, int to) {
		this.length = length;
		this.from = from;
		this.to = to;
	}

	public int getLength() {
		return length;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}
}
