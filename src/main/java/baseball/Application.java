package baseball;

import baseball.controller.GameBuilder;
import baseball.controller.GameController;

public class Application {
	public static void main(String[] args) {
		// TODO 숫자 야구 게임 구현

		GameBuilder gameBuilder = new GameBuilder();
		GameController controller = gameBuilder.build();

		controller.listen();
	}
}
