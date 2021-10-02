package baseball.view;

import baseball.domain.Game;
import baseball.domain.GameRecord;

public class GameView {

    public void response(Game game) {
        System.out.print(chooseMessage(game));
    }

    public void response(GameRecord record) {
        String message = "";

        if (record.getStrike() > 0) message += record.getStrike() + "스트라이크 ";
        if (record.getBall() > 0) message += record.getBall() +"볼 ";
        if (record.getStrike() < 1 && record.getBall() < 1) message = "낫싱";

        if (record.getStrike() == 3) message += "\n3개의 숫자를 모두 맞히셨습니다! 게임 끝";

        message = message.trim();
        System.out.println(message);
    }

    private String chooseMessage(Game game) {
        if (game.isPlaying()) return GuidMessage.MSG_FOR_PLAY;

        return GuidMessage.MSG_FOR_START;
    }

    public void responseError(String errorMessage) {
        System.out.print("[ERROR]" + errorMessage);
    }
}
