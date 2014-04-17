import java.util.List;


public interface QuizQuestions {

	int getQuizId();

	void setQuizId(int quizId);

	String getQuizName();

	void setQuizName(String quizName);

	List<Question> getQuestionList();

	void setQuestionList(List<Question> questionList);
	/**
	 * Add a question to the quiz
	 * Checks that there are no duplicates in the question list
	 * @param question object that contains possible answers and the correct answer
	 */
	void addQuestion(Question question);
	/**
	 * Returns question linked to the question number in the quiz
	 * @param questionNumber of the the question in the quiz
	 * @return question that was requested 
	 */
	Question getQuestion(int questionNumber);
}
