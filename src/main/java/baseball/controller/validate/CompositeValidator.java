package baseball.controller.validate;

import java.util.Arrays;
import java.util.List;

public class CompositeValidator implements InputValidator {

	private final List<InputValidator> validators;

	public CompositeValidator(InputValidator... validators) {
		this.validators = Arrays.asList(validators);
	}

	@Override
	public void validate(String input) throws IllegalArgumentException {
		for (InputValidator validator : validators) {
			validator.validate(input);
		}
	}
}
