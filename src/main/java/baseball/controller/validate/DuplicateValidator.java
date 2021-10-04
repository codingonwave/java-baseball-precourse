package baseball.controller.validate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateValidator implements InputValidator {
	@Override
	public void validate(String input) throws IllegalArgumentException {

		if (input == null || input.length() < 1 || containDuplicateNum(input)) {
			throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요: ");
		}
	}

	private boolean containDuplicateNum(String input) {
		String[] elements = input.split("");
		Set<String> set = new HashSet<>(Arrays.asList(elements));

		return set.size() != elements.length;
	}
}
