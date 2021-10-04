package baseball.domain;

public class StrikeCounter extends Counter {
	@Override
	protected int countable(String answer, String ithInput, String ithAnswer) {
		if (ithInput.equals(ithAnswer)) {
			return 1;
		}

		return 0;
	}
}
