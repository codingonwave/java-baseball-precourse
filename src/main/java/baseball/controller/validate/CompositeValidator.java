package baseball.controller.validate;

import baseball.domain.Game;

import java.util.List;

public class CompositeValidator implements InputValidator {

    private final List<InputValidator> validators;

    public CompositeValidator(List<InputValidator> validators) {
        this.validators = validators;
    }

    @Override
    public void validate(String input) throws IllegalArgumentException {
        for (InputValidator validator : validators) {
            validator.validate(input);
        }
    }
}
