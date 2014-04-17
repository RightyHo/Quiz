import java.util.List;


public interface QuizResults {
	/**
	 * gets the quiz ID number
	 * @return int the quiz ID number
	 */
	int getQuizId();
	/**
	 * Returns a list of the results of the various user attempts on this quiz
	 * @return an integer list of the results of the various user attempts on this quiz
	 */
	List<Integer> getUserResultsList();
	/**
	 * Adds a new user result to the user results list
	 * @param score the new user result to add the user results list
	 */
	void addUserResult(int score);
	/**
	 * Returns the highest score on the quiz
	 * @return int showing the highest score on the quiz
	 */
	int getHighScore();
	/**
	 * Returns the name of the current winner of this quiz game
	 * @return string of the name of the current winner of this quiz game
	 */
	public String getCurrentWinner();
}
