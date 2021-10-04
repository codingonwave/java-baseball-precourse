package baseball.controller.validate;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("InputValidator 인터페이스")
class InputValidatorTest {

	@Nested
	@DisplayName("LengthValidator 클래스")
	class TestLengthValidator {
		@Nested
		@DisplayName("validate 메소드는")
		class DescribeValidate {
			private final int length = 3;
			private final InputValidator validator = new LengthValidator(length);

			@Nested
			@DisplayName("input 길이가 3이면")
			class ContextValidInput {

				@DisplayName("exception을 발생시키지 않는다")
				@Test
				void it_throw_exception() {
					String input = "123";
					validator.validate(input);
				}
			}

			@Nested
			@DisplayName("input이 null이면")
			class ContextNullInput {
				private final String input = null;

				@DisplayName("IllegalArgumentException을 발생시킨다")
				@Test
				void it_throw_exception() {
					assertThatThrownBy(() -> validator.validate(input))
						.isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Nested
			@DisplayName("input이 empty면")
			class ContextEmptyInput {
				private final String input = "";

				@DisplayName("IllegalArgumentException을 발생시킨다")
				@Test
				void it_throw_exception() {
					assertThatThrownBy(() -> validator.validate(input))
						.isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Nested
			@DisplayName("input의 길이가 3보다 짧으면")
			class ContextShortInput {
				private final String input = "12";

				@DisplayName("IllegalArgumentException을 발생시킨다")
				@Test
				void it_throw_exception() {
					assertThatThrownBy(() -> validator.validate(input))
						.isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Nested
			@DisplayName("input의 길이가 3보다 길면")
			class ContextLongInput {
				private final String input = "1234";

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
	class TestNumericValidator {
		@Nested
		@DisplayName("validate 메소드는")
		class DescribeValidate {
			private final InputValidator validator = new NumericValidator();

			@Nested
			@DisplayName("input이 숫자만 포함한다면")
			class ContextValidInput {

				@DisplayName("exception을 발생시키지 않는다")
				@Test
				void it_throw_exception() {
					String input = "123";
					validator.validate(input);
				}
			}

			@Nested
			@DisplayName("input이 null이면")
			class ContextNullInput {
				private final String input = null;

				@DisplayName("IllegalArgumentException을 발생시킨다")
				@Test
				void it_throw_exception() {
					assertThatThrownBy(() -> validator.validate(input))
						.isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Nested
			@DisplayName("input이 empty면")
			class ContextEmptyInput {
				private final String input = "";

				@DisplayName("IllegalArgumentException을 발생시킨다")
				@Test
				void it_throw_exception() {
					assertThatThrownBy(() -> validator.validate(input))
						.isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Nested
			@DisplayName("input에 문자가 포함되어 있으면")
			class ContextLongInput {
				private final String input = "a12";

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
	class TestRangeValidator {
		@Nested
		@DisplayName("validate 메소드는")
		class DescribeValidate {
			private final int from = 1;
			private final int to = 9;
			private final InputValidator validator = new RangeValidator(from, to);

			@Nested
			@DisplayName("input의 각 숫자가 모두 1~9사이의 숫자라면")
			class ContextValidInput {

				@DisplayName("exception을 발생시키지 않는다")
				@Test
				void it_throw_exception() {
					String input = "123";
					validator.validate(input);
				}
			}

			@Nested
			@DisplayName("input이 null이면")
			class ContextNullInput {
				private final String input = null;

				@DisplayName("IllegalArgumentException을 발생시킨다")
				@Test
				void it_throw_exception() {
					assertThatThrownBy(() -> validator.validate(input))
						.isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Nested
			@DisplayName("input이 empty면")
			class ContextEmptyInput {
				private final String input = "";

				@DisplayName("IllegalArgumentException을 발생시킨다")
				@Test
				void it_throw_exception() {
					assertThatThrownBy(() -> validator.validate(input))
						.isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Nested
			@DisplayName("input이 1~9를 벗어난 숫자가 포함되어 있다면")
			class ContextLongInput {
				private final String input = "012";

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
	class TestDuplicateValidator {
		@Nested
		@DisplayName("validate 메소드는")
		class DescribeValidate {
			private final InputValidator validator = new DuplicateValidator();

			@Nested
			@DisplayName("input에 중복된 숫자가 없다면")
			class ContextValidInput {

				@DisplayName("exception을 발생시키지 않는다")
				@Test
				void it_throw_exception() {
					String input = "123";
					validator.validate(input);
				}
			}

			@Nested
			@DisplayName("input이 null이면")
			class ContextNullInput {
				private final String input = null;

				@DisplayName("IllegalArgumentException을 발생시킨다")
				@Test
				void it_throw_exception() {
					assertThatThrownBy(() -> validator.validate(input))
						.isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Nested
			@DisplayName("input이 empty면")
			class ContextEmptyInput {
				private final String input = "";

				@DisplayName("IllegalArgumentException을 발생시킨다")
				@Test
				void it_throw_exception() {
					assertThatThrownBy(() -> validator.validate(input))
						.isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Nested
			@DisplayName("input에 중복된 숫자가 있다면")
			class ContextLongInput {
				private final String input = "112";

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
