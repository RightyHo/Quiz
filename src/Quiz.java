import java.util.ArrayList;
import java.util.List;


public interface Quiz {
/**
 * Add a question to the quiz
 * Checks that there are no duplicates in the question list
 * @param question string
 * @param answerList a list of possible answers including the correct answer
 */
	void addQuestion(String question,Answer answerList);
/**
 * Returns the high score for this quiz
 */
	int getHighScore();
/**
 * Returns quiz ID
 */
	int getQuizId();
}
