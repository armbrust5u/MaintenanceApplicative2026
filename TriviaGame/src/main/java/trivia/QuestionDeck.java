package trivia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class QuestionDeck {

    private Map<Category, Queue<String>> questions = new HashMap<>();

    public QuestionDeck() {
        for (Category c : Category.values()) {
            questions.put(c, new LinkedList<>());
        }

        for (int i = 0; i < 50; i++) {
            questions.get(Category.POP).add("Pop Question " + i);
            questions.get(Category.SCIENCE).add("Science Question " + i);
            questions.get(Category.SPORTS).add("Sports Question " + i);
            questions.get(Category.ROCK).add("Rock Question " + i);
        }
    }

    public String drawQuestion(Category category) {
        return questions.get(category).remove();
    }
}