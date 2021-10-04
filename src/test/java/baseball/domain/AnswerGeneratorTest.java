package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("AnswerGenerator 클래스")
class AnswerGeneratorTest {

	@Nested
	@DisplayName("generate 메소드는")
	class DescribeGenerate {
		final GameRule rule = new GameRule(3, 1, 9);
		final AnswerGenerator generator = new AnswerGenerator(rule);

		@Nested
		@DisplayName("호출되면")
		class ContextCall {
			final String answer = generator.generate();

			@DisplayName("길이가 3인 정답을 리턴한다")
			@Test
			void it_right_length_answer() {
				assertThat(answer.length()).isEqualTo(rule.getLength());
			}

			@DisplayName("서로 다른 숫자로 이뤄진 정답을 리턴한다")
			@Test
			void it_unique_answer() {
				String[] elements = answer.split("");
				Set<String> uniqueAnswer = new HashSet<>(Arrays.asList(elements));

				assertThat(answer.length()).isEqualTo(uniqueAnswer.size());
			}

			@DisplayName("1~9사이의 수로만 이뤄진 정답을 리턴한다")
			@Test
			void it_valid_range_answer() {
				String[] elements = answer.split("");
				for (String element : elements) {
					int number = Integer.parseInt(element);
					assertThat(number).isBetween(rule.getFrom(), rule.getTo());
				}
			}
		}
	}
}
