public interface Quiz {
	/**
	 * Returns quiz questions
	 * @return QuizQuestions an object containing a quiz questions list as well as name, ID, and answer information
	 */
	QuizQuestions getQuizQuestions();
	/**
	 * Records player answers in the playerAnswers list
	 * @param questionNumber connects the given answer to the relevant question in the quiz
	 * @param answer char a,b,c, or d relating to the multi-choice question
	 */
	void recordAnswer(int questionNumber,char answer);
	/**
	 * Returns the answer in the playerAnswers list
	 * @param questionNumber the question number of the player answer we are looking for
	 * @return char of the player answer stored for the question number
	 */
	Character getPlayerAnswer(int questionNumber);	
	/**
	 * Calculates and returns the score of a completed quiz
	 * updates results list with the score
	 * @return the number of correct answers
	 */
	int calculatePlayerScore();
	/**
	 * Add a question to the quiz
	 * Checks that there are no duplicates in the question list
	 * @param question object that contains possible answers and the correct answer
	 */
	//void addQuestion(Question question);
	/**
	 * Returns question linked to the question number in the quiz
	 * @param questionNumber of the the quesion in the quiz
	 * @return the requested question
	 */
	//Question getQuestion(int questionNumber);
	/**
	 * Returns quiz ID
	 * @return quizId
	 */
	//int getQuizId();
	/**
	 * Sets the quiz name
	 * @param quizName String
	 */
	//void setQuizName(String quizName);
	/**
	 * Returns the quiz name
	 * @return String of the quiz name
	 */
	//String getQuizName();
	/**
	 * Sets the highscore for this quiz
	 * @param highScore new high score for this quiz
	 */
	//void setHighScore(int highScore);
	/**
	 * Returns the high score for this quiz
	 * @return highScore
	 */
	//int getHighScore();
	/**
	 * Sets the name of the person with the current highest score for this quiz
	 * @param currentWinner the name of the person with the current highest score for this quiz
	 */
	//void setCurrentWinner(String currentWinner);
	/**
	 * Gets the name of the person with the current highest score for this quiz
	 * @return currentWinner the name of the person with the current highest score for this quiz
	 */
	//String getCurrentWinner();
	/**
	 * Returns the number of questions in the quiz
	 * @return int the number of questions in the quiz
	 */
	//int getNumberOfQuestions();
	/**
	 * Returns a list of the results of the various user attempts on this quiz
	 * @return integer list representing the results all of the various user attempts on this quiz
	 */
	//List<Integer> getResultsList();
}
