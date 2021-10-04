package baseball.view;

import baseball.domain.Game;
import baseball.domain.GameRecord;

public class GameView {

	public void response(Game game) {
		System.out.print(chooseMessage(game));
	}

	private String chooseMessage(Game game) {
		if (game.isPlaying()) {
			return GuidMessage.MSG_FOR_PLAY;
		}
		return GuidMessage.MSG_FOR_START;
	}

	public void response(GameRecord record) {
		String message = "";
		message += strikeMessage(record);
		message += ballMessage(record);
		message += otherMessage(record);
		message = message.trim();
		System.out.println(message);
	}

	private String strikeMessage(GameRecord record) {
		if (record.getStrike() > 0) {
			return record.getStrike() + "스트라이크 ";
		}
		return "";
	}

	private String ballMessage(GameRecord record) {
		if (record.getBall() > 0) {
			return record.getStrike() + "볼 ";
		}
		return "";
	}

	private String otherMessage(GameRecord record) {
		if (record.getStrike() < 1 && record.getBall() < 1) {
			return "낫싱";
		}

		if (record.getStrike() == 3) {
			return "\n3개의 숫자를 모두 맞히셨습니다! 게임 끝";
		}
		return "";
	}

	public void responseError(String errorMessage) {
		System.out.print("[ERROR]" + errorMessage);
	}
}
