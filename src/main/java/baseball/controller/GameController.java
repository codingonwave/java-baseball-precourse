package baseball.controller;

import baseball.controller.validate.*;
import baseball.domain.Game;
import baseball.domain.GameRule;
import baseball.view.GameView;
import nextstep.utils.Console;

public class GameController {

    private final GameView gameView = new GameView();

    private final InputValidator validator;

    private final GameRule rule;

    private Game game;

    public GameController(GameRule rule) {

        this.game = new Game();
        this.rule = rule;
        this.validator = new CompositeValidator(
                new LengthValidator(rule.getLength()),
                new NumericValidator(),
                new RangeValidator(rule.getFrom(), rule.getTo()));

        initMessage();
    }

    public void listen() {
        String input = "";
        while(keepGoing(game, input)) {
            input = readInput();
            try {
                validateInput(game, input);
                startGame(input);
                response(input);
            } catch (IllegalArgumentException ex) {
                responseError(ex.getMessage());
            }
        }
    }

    private void initMessage() {
        gameView.response();
    }

    private boolean keepGoing(Game game, String input) {
        if (game.isPlaying()) return true;

        return !game.isPlaying() && !input.equals(Command.END);
    }

    private String readInput() {
        return Console.readLine();
    }

    private void validateInput(Game game, String input) {
        if (game.isPlaying()) {
            validator.validate(input);
        }
    }

    private void startGame(String input) {
        if (!game.isPlaying() && input.equals(Command.START)) {
            game.start();
        }
    }

    private void response(String input) {
        if (!game.isPlaying() && input.equals(Command.END)) return;

        gameView.response(game);
    }

    private void responseError(String errorMessage) {
        gameView.responseError(errorMessage);
    }
}
