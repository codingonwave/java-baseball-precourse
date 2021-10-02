package baseball;

import baseball.controller.GameController;
import baseball.domain.GameRule;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현

        GameRule gameRule = new GameRule(3, 1, 9);
        GameController controller = new GameController(gameRule);
        controller.listen();
    }
}
