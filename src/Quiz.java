import java.util.ArrayList;
import java.util.List;


public interface Quiz {
	/**
	 * Add a question to the quiz
	 * Checks that there are no duplicates in the question list
	 * @param question object that contains possible answers and the correct answer
	 */
	void addQuestion(String question);
	/**
	 * Records player answers in the playerAnswers list
	 * @param questionNumber connects the given answer to the relevant question in the quiz
	 * @param answer char a,b,c, or d relating to the multi-choice question
	 */
	void recordAnswer(int questionNumber,char answer);
	/**
	 * Returns quiz ID
	 * @return quizId
	 */
	int getQuizId();
	/**
	 * Sets the quiz name
	 * @param quizName String 
	 */
	void setQuizName(Sting quizName);
	/**
	 * Returns the quiz name
	 * @return String of the quiz name
	 */
	String getQuizName();
	/**
	 * Sets the highscore for this quiz
	 * @param highScore new high score for this quiz
	 */
	void setHighScore(int highScore);
	/**
	 * Returns the high score for this quiz
	 * @return highScore
	 */
	int getHighScore();
	/**
	 * Sets the name of the person with the current highest score for this quiz
	 * @param currentWinner the name of the person with the current highest score for this quiz
	 */
	void setCurrentWinner(String currentWinner);
	/**
	 * Gets the name of the person with the current highest score for this quiz
	 * @return currentWinner the name of the person with the current highest score for this quiz
	 */
	String getCurrentWinner();
}
