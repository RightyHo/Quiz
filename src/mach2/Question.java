package mach2;

public interface Question {
	
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
	
	/**
	 * Returns the requested possible answer
	 * @param whichAnswer a char denoting which answer A,B,C or D is being requested
	 * @return answer string or null if the parameters are outside of the bounds
	 * @throws IllegalArgumentException
	 */
	String getAnswer(char whichAnswer);
	
	/**
	 * Returns the letter that represents the correct possible answer to the question
	 * @return char the letter of the correct answer
	 */
	char getCorrectAnswer();
	
	/**
	 * Checks whether the question is set up correctly
	 * @return boolean value reports whether a question is valid or not
	 */
	boolean isQuestionValid();
}

