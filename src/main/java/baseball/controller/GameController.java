package baseball.controller;

import baseball.controller.validate.InputValidator;
import baseball.domain.Game;
import baseball.domain.GameRecord;
import baseball.domain.GameRule;
import baseball.view.GameView;
import nextstep.utils.Console;

public class GameController {

	private final GameView gameView = new GameView();

	private final InputValidator validator;

	private final Game game;

	public GameController(GameRule rule, InputValidator validator) {
		this.game = new Game(rule);
		this.validator = validator;
	}

	public void listen() {
		init();
		String input;
		do {
			input = readInput();
			play(input);
		} while (keepGoing(game, input));
	}

	private void init() {
		game.start();
		gameView.response(game);
	}

	private String readInput() {
		return Console.readLine();
	}

	private void play(String input) {
		try {
			validateInput(game, input);
			playGame(input);
			response(input);
		} catch (IllegalArgumentException | IllegalAccessException ex) {
			responseError(ex.getMessage());
		}
	}

	private void validateInput(Game game, String input) {
		if (game.isPlaying()) {
			validator.validate(input);
		}
	}

	private void playGame(String input) throws IllegalAccessException {
		if (!game.isPlaying() && input.equals(Command.START)) {
			game.start();
			return;
		}

		if (game.isPlaying()) {
			GameRecord record = game.play(input);
			gameView.response(record);
		}
	}

	private void response(String input) {
		if (!game.isPlaying() && input.equals(Command.END)) {
			return;
		}

		gameView.response(game);
	}

	private void responseError(String errorMessage) {
		gameView.responseError(errorMessage);
	}

	private boolean keepGoing(Game game, String input) {
		if (game.isPlaying()) {
			return true;
		}

		return !game.isPlaying() && !input.equals(Command.END);
	}
}
