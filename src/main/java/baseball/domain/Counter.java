package baseball.domain;

import java.util.Arrays;
import java.util.List;

public abstract class Counter {

	public int count(String answer, String input) {
		List<String> answers = splitToNumberList(answer);
		List<String> inputNumbers = splitToNumberList(input);
		int number = 0;
		for (int index = 0; index < inputNumbers.size(); index++) {
			number += countable(answer, inputNumbers.get(index), answers.get(index));
		}

		return number;
	}

	protected abstract int countable(String answer, String ithInput, String ithAnswer);

	private List<String> splitToNumberList(String input) {
		String[] split = input.split("");
		return Arrays.asList(split);
	}
}
