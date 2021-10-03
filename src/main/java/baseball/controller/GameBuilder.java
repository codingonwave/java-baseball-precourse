package baseball.controller;

import baseball.controller.validate.*;
import baseball.domain.GameRule;

public class GameBuilder {

    public GameController build() {
        GameRule gameRule = buildGameRule();
        InputValidator validator = buildValidator(gameRule);

        return new GameController(gameRule, validator);
    }

    private GameRule buildGameRule() {
        return new GameRule(3, 1, 9);
    }

    private InputValidator buildValidator(GameRule gameRule) {
        return new CompositeValidator(
                new LengthValidator(gameRule.getLength()),
                new NumericValidator(),
                new RangeValidator(gameRule.getFrom(), gameRule.getTo()),
                new DuplicateValidator());
    }
}
