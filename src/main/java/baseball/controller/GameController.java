package baseball.controller;

import baseball.domain.Game;
import baseball.view.GameView;
import nextstep.utils.Console;

public class GameController {

    private final GameView gameView = new GameView();

    private Game game;

    public GameController() {
        this.game = new Game();
        initMessage();
    }

    public void listen() {
        String input = "";
        while(keepGoing(game, input)) {
            input = readInput();
            startGame(input);
            response(input);
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

    private void startGame(String input) {
        if (!game.isPlaying() && input.equals(Command.START)) {
            game.start();
        }
    }

    private void response(String input) {
        if (!game.isPlaying() && input.equals(Command.END)) return;

        gameView.response(game);
    }
}
