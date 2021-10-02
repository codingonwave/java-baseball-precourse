package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Game 클래스")
class GameTest {

    @Nested
    @DisplayName("start 메소드는")
    class Describe_start {

        @Nested
        @DisplayName("호출되면")
        class Context_call {
            @DisplayName("Game 객체의 playing 속성에 true를 할당한다")
            @Test
            void it_set_playing_true() {

            }
        }
    }
}