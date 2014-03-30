import java.util.Set;


public interface Question {
	/**
	 * Sets question ID number
	 * @param question ID number
	 */
	void setQuestionId(int questionId);
	/**
	 * Returns question ID number
	 * @return question ID number
	 */
	int getQuestionId();
	/**
	 * Sets the question string
	 * @param question a string
	 */
	void setQuestion(String question);
	/**
	 * Returns the question string
	 * @return question string
	 */
	String getQuestion();
	/**
	 * Sets the four possible answer fields and indicates which one of them is the correct answer
	 * @param answerA possible answer string
	 * @param answerB possible answer string	
	 * @param answerC possible answer string	
	 * @param answerD possible answer string	
	 * @param correctAnswer char indicating which answer is correct	 
	 */
	void setAnswers(String answerA,String answerB,String answerC,String answerD,char correctAnswer);
}
