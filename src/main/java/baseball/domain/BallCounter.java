package baseball.domain;

public class BallCounter extends Counter {
	@Override
	protected int countable(String answer, String ithInput, String ithAnswer) {
		if (!ithInput.equals(ithAnswer) && answer.contains(ithInput)) {
			return 1;
		}
		return 0;
	}
}
