package baseball.controller.validate;

import baseball.domain.Game;

public class LengthValidator implements InputValidator {

    private final int length;

    public LengthValidator(int length) {
        this.length = length;
    }

    @Override
    public void validate(String input) throws IllegalArgumentException {
        if (input == null || input.length() != length) {
            throw new IllegalArgumentException(length + "자리 숫자를 입력해주세요");
        }
    }
}
