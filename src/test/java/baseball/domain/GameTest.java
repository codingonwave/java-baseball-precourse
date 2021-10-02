package baseball.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Game 클래스")
class GameTest {
    Game game;

    @Nested
    @DisplayName("start 메소드는")
    class Describe_start {

        @Nested
        @DisplayName("호출되면")
        class Context_call {
            @BeforeEach
            void callStartMethod() {
                game = new Game(new GameRule(3, 1, 9));
                game.start();
            }

            @DisplayName("Game 객체의 playing 속성에 true를 할당한다")
            @Test
            void it_set_playing_true() {
                assertThat(game.isPlaying()).isTrue();
            }

            @DisplayName("Game 객체의 answer 속성에 새롭게 생성된 정답을 할당한다")
            @Test
            void it_set_answer() {
                assertThat(game.getAnswer()).isNotEmpty();
            }
        }
    }

    @Nested
    @DisplayName("countStrike 메소드는")
    class Describe_countStrike {

        GameRule rule = new GameRule(3, 1, 9);
        Game game = new Game(rule);

        @Nested
        @DisplayName("사용자가 입력한 3자리 숫자를 받아서")
        class Context_input {

            @BeforeEach
            void setAnswer() {
                game.start();
                game.setAnswer("123");
            }

            @DisplayName("정답과 비교하여 스트라이크 개수를 리턴한다")
            @ParameterizedTest(name = "input: {0}, strike:{1}")
            @CsvSource({"123, 3", "125, 2","321, 1", "456, 0"})
            void it_count_strike(String input, Integer expected) throws IllegalAccessException {
                int actual = game.countStrike(input);
                assertThat(actual).isEqualTo(expected);
            }
        }
    }
}