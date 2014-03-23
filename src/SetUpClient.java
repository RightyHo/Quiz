import java.util.Set;


public interface SetUpClient {
/**
 * Enable a user to create a new quiz 
 * @param quizName for the quiz
 * @param questionSet a set of questions
 * @param possibleAnswers a set of possible answers for each question
 * @return quizId a quiz game id
 */
	int createNewQuiz(String quizName,Set<Question> questionSet,Set<Answer> possibleAnswers);
}
