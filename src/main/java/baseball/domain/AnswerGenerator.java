package baseball.domain;

import nextstep.utils.Randoms;

public class AnswerGenerator {

    private final GameRule rule;

    public AnswerGenerator(GameRule rule) {
        this.rule = rule;
    }

    public String generate() {
        StringBuilder answer = new StringBuilder();

        while(answer.length() < rule.getLength()) {
            answer.append(getRandomNumber(answer.toString()));
        }

        return answer.toString();
    }

    private String getRandomNumber(String currentAnswer) {
        String newNumber = String.valueOf(Randoms.pickNumberInRange(rule.getFrom(), rule.getTo()));
        if (currentAnswer.contains(newNumber)) return "";

        return newNumber;
    }
}
