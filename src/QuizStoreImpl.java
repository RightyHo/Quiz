import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class QuizStoreImpl implements QuizStore,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Integer,QuizQuestions> questionsForQuizId = new HashMap<>();
	private Map<Integer,QuizResults> resultsForQuizId = new HashMap<>();
}
