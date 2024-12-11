package structra.assignment.task.de.rub.client;

import lombok.NonNull;
import structra.assignment.framework.llm.gen.questions.QuestionGenerationTarget;
import structra.assignment.framework.model.question.base.Question;

public class MultipleChoiceQuestionTarget implements QuestionGenerationTarget {

    @Override
    public String getBasePrompt() {
        return "";
    }

    @Override
    public Question<?> parse(String input) {
        return null;
    }

    @Override
    public @NonNull String getTargetContext() {
        return "";
    }
}
