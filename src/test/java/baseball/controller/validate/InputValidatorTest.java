package baseball.controller.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("InputValidator 인터페이스")
class InputValidatorTest {

    @Nested
    @DisplayName("LengthValidator 클래스")
    class Test_LengthValidator {
        @Nested
        @DisplayName("validate 메소드는")
        class Describe_validate {
            private int length = 3;
            private InputValidator validator = new LengthValidator(length);

            @Nested
            @DisplayName("input 길이가 3이면")
            class Context_valid_input {
                private String input = "123";

                @DisplayName("exception을 발생시키지 않는다")
                @Test
                void it_throw_exception() {
                    validator.validate(input);
                }
            }

            @Nested
            @DisplayName("input이 null이면")
            class Context_null_input {
                private String input = null;

                @DisplayName("IllegalArgumentException을 발생시킨다")
                @Test
                void it_throw_exception() {
                    assertThatThrownBy(() -> validator.validate(input))
                            .isInstanceOf(IllegalArgumentException.class);
                }
            }

            @Nested
            @DisplayName("input이 empty면")
            class Context_empty_input {
                private String input = "";

                @DisplayName("IllegalArgumentException을 발생시킨다")
                @Test
                void it_throw_exception() {
                    assertThatThrownBy(() -> validator.validate(input))
                            .isInstanceOf(IllegalArgumentException.class);
                }
            }

            @Nested
            @DisplayName("input의 길이가 3보다 짧으면")
            class Context_short_input {
                private String input = "12";

                @DisplayName("IllegalArgumentException을 발생시킨다")
                @Test
                void it_throw_exception() {
                    assertThatThrownBy(() -> validator.validate(input))
                            .isInstanceOf(IllegalArgumentException.class);
                }
            }

            @Nested
            @DisplayName("input의 길이가 3보다 길면")
            class Context_long_input {
                private String input = "1234";

                @DisplayName("IllegalArgumentException을 발생시킨다")
                @Test
                void it_throw_exception() {
                    assertThatThrownBy(() -> validator.validate(input))
                            .isInstanceOf(IllegalArgumentException.class);
                }
            }
        }
    }

    @Nested
    @DisplayName("NumericValidator 클래스")
    class Test_NumericValidator {
        @Nested
        @DisplayName("validate 메소드는")
        class Describe_validate {
            private InputValidator validator = new NumericValidator();

            @Nested
            @DisplayName("input이 숫자만 포함한다면")
            class Context_valid_input {
                private String input = "123";

                @DisplayName("exception을 발생시키지 않는다")
                @Test
                void it_throw_exception() {
                    validator.validate(input);
                }
            }

            @Nested
            @DisplayName("input이 null이면")
            class Context_null_input {
                private String input = null;

                @DisplayName("IllegalArgumentException을 발생시킨다")
                @Test
                void it_throw_exception() {
                    assertThatThrownBy(() -> validator.validate(input))
                            .isInstanceOf(IllegalArgumentException.class);
                }
            }

            @Nested
            @DisplayName("input이 empty면")
            class Context_empty_input {
                private String input = "";

                @DisplayName("IllegalArgumentException을 발생시킨다")
                @Test
                void it_throw_exception() {
                    assertThatThrownBy(() -> validator.validate(input))
                            .isInstanceOf(IllegalArgumentException.class);
                }
            }

            @Nested
            @DisplayName("input에 문자가 포함되어 있으면")
            class Context_long_input {
                private String input = "a12";

                @DisplayName("IllegalArgumentException을 발생시킨다")
                @Test
                void it_throw_exception() {
                    assertThatThrownBy(() -> validator.validate(input))
                            .isInstanceOf(IllegalArgumentException.class);
                }
            }
        }
    }

    @Nested
    @DisplayName("RangeValidator 클래스")
    class Test_RangeValidator {
        @Nested
        @DisplayName("validate 메소드는")
        class Describe_validate {
            private int from = 1;
            private int to = 9;
            private InputValidator validator = new RangeValidator(from, to);

            @Nested
            @DisplayName("input의 각 숫자가 모두 1~9사이의 숫자라면")
            class Context_valid_input {
                private String input = "123";

                @DisplayName("exception을 발생시키지 않는다")
                @Test
                void it_throw_exception() {
                    validator.validate(input);
                }
            }

            @Nested
            @DisplayName("input이 null이면")
            class Context_null_input {
                private String input = null;

                @DisplayName("IllegalArgumentException을 발생시킨다")
                @Test
                void it_throw_exception() {
                    assertThatThrownBy(() -> validator.validate(input))
                            .isInstanceOf(IllegalArgumentException.class);
                }
            }

            @Nested
            @DisplayName("input이 empty면")
            class Context_empty_input {
                private String input = "";

                @DisplayName("IllegalArgumentException을 발생시킨다")
                @Test
                void it_throw_exception() {
                    assertThatThrownBy(() -> validator.validate(input))
                            .isInstanceOf(IllegalArgumentException.class);
                }
            }

            @Nested
            @DisplayName("input이 1~9를 벗어난 숫자가 포함되어 있다면")
            class Context_long_input {
                private String input = "012";

                @DisplayName("IllegalArgumentException을 발생시킨다")
                @Test
                void it_throw_exception() {
                    assertThatThrownBy(() -> validator.validate(input))
                            .isInstanceOf(IllegalArgumentException.class);
                }
            }
        }
    }

    @Nested
    @DisplayName("DuplicateValidator 클래스")
    class Test_DuplicateValidator {
        @Nested
        @DisplayName("validate 메소드는")
        class Describe_validate {
            private InputValidator validator = new DuplicateValidator();

            @Nested
            @DisplayName("input에 중복된 숫자가 없다면")
            class Context_valid_input {
                private String input = "123";

                @DisplayName("exception을 발생시키지 않는다")
                @Test
                void it_throw_exception() {
                    validator.validate(input);
                }
            }

            @Nested
            @DisplayName("input이 null이면")
            class Context_null_input {
                private String input = null;

                @DisplayName("IllegalArgumentException을 발생시킨다")
                @Test
                void it_throw_exception() {
                    assertThatThrownBy(() -> validator.validate(input))
                            .isInstanceOf(IllegalArgumentException.class);
                }
            }

            @Nested
            @DisplayName("input이 empty면")
            class Context_empty_input {
                private String input = "";

                @DisplayName("IllegalArgumentException을 발생시킨다")
                @Test
                void it_throw_exception() {
                    assertThatThrownBy(() -> validator.validate(input))
                            .isInstanceOf(IllegalArgumentException.class);
                }
            }

            @Nested
            @DisplayName("input에 중복된 숫자가 있다면")
            class Context_long_input {
                private String input = "112";

                @DisplayName("IllegalArgumentException을 발생시킨다")
                @Test
                void it_throw_exception() {
                    assertThatThrownBy(() -> validator.validate(input))
                            .isInstanceOf(IllegalArgumentException.class);
                }
            }
        }
    }
}