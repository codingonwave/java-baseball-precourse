package baseball.controller.validate;

import baseball.domain.Game;

public class NumericValidator implements InputValidator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        if (input == null || input.length() == 0 || containCharacter(input)) {
            throw new IllegalArgumentException("숫자만 입력해주세요: ");
        }
    }

    private boolean containCharacter(String input) {
        char[] numbers = input.toCharArray();
        boolean result = false;

        for (char number : numbers) {
            result = result || isNotNumber(number);
        }

        return result;
    }

    private boolean isNotNumber(char target) {
        return !Character.isDigit(target);
    }
}
