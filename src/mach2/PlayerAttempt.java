package mach2;

public interface PlayerAttempt {
	
	/**
	 * Returns the quiz question corresponding to the question number passed as parameter
	 * @param questionNumber
	 * @return Question
	 */
	Question getQuestion(int questionNumber);
	
	/**
	 * Increments the player score by one
	 */
	void addMarkToScore();
	
	/**
	 * Returns the player score
	 * @return integer value of the player score
	 */
	int getPlayerScore();
	
	/**
	 * Checks whether this player attempt is the new high score and adds the player score to the quiz results list  
	 */
	void saveResult();
	
	/**
	 * Returns the quiz that this player attempt is based on
	 * @return Quiz that this player attempt is based on
	 */
	Quiz getQuiz();

	/**
	 * Returns the name of the player attempting the quiz
	 * @return String value of the player name
	 */
	String getPlayerName();
}
