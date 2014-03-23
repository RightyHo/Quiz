import java.util.Set;


public interface Question {
/**
 * Create new question
 * @param questionId question ID number
 * @param question string 
 * @param possibleAnswers set of possible answers to the question
 */
void createQuestion(int questionId,String question,Set<Answer> possibleAnswers);
}
