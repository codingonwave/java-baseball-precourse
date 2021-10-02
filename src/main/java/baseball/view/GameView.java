package baseball.view;

import baseball.domain.Game;

public class GameView {

    public void response() {
        System.out.print(GuidMessage.MSG_FOR_START);
    }

    public void response(Game game) {
        System.out.print(chooseMessage(game));
    }

    private String chooseMessage(Game game) {
        if (game.isPlaying()) return GuidMessage.MSG_FOR_PLAY;

        return GuidMessage.MSG_FOR_START;
    }

    public void responseError(String errorMessage) {
        System.out.print("[ERROR]" + errorMessage);
    }
}
