package mach2;

public interface Quiz {

	/**
	 * Returns the quiz ID
	 * @param int value representing the quiz ID
	 */
	int getQuizId();
	
	/**
	 * Returns the Quiz Name
	 * @return String of the quiz name
	 */
	String getQuizName();
	
	/**
	 * Adds a question to the quiz question list
	 * @param newQuestion
	 * @return String of the new quiz question that has been added to the list
	 * @throws IllegalArgumentException
	 */
	String addQuestionToQuiz(Question newQuestion);
	
	/**
	 * Returns the question related to the question number passed to the method
	 * @param questionNumber 
	 * @return Question
	 * @throws IndexOutOfBoundsException
	 */
	Question getQuestion(int questionNumber);
	
	/**
	 * returns the current winner of the quiz
	 * @return String of the current winner of the quiz
	 */
	String getCurrentWinner();
	
	/**
	 * returns the current high score of the quiz
	 * @return int value of the current high score of the quiz
	 */
	int getHighScore();
	
	/**
	 * Checks whether the quiz is set up correctly with a quiz ID and name
	 * @return boolean value of true if the quiz is valid or false if it is not
	 */
	boolean isQuizValid();
	
	/**
	 * Adds the player score to the quiz results list.  Checks whether this player score is the new high score and
	 * if so requests the players name and stores the input with the quiz record
	 * @param playerScore
	 */
	void saveResult(int playerScore);
}
