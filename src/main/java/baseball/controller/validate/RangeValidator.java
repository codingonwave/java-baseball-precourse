package baseball.controller.validate;

import baseball.domain.Game;

public class RangeValidator implements InputValidator {

    private final int from;

    private final int to;

    public RangeValidator(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void validate(String input) throws IllegalArgumentException {
        if ((input == null) || containOutOfRange(input)) {
            throw new IllegalArgumentException(from + " ~ " + to + " 숫자만 입력해주세요");
        }
    }

    private boolean containOutOfRange(String input) {
        String[] numbers = input.split("");
        boolean result = false;

        for (String number : numbers) {
            int parsedNum = Integer.parseInt(number);
            result = result || outOfRange(parsedNum);
        }

        return result;
    }

    private boolean outOfRange(int number) {
        return (number < from) || (number > to);
    }
}
