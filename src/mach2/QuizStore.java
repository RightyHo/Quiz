package mach2;

import java.util.List;

public interface QuizStore {
	
	/**
	 * Creates a new Quiz
	 * @param quizName
	 * @return Quiz 
	 * @throws IllegalArgumentException
	 */
	Quiz createNewQuiz(String quizName);

	/**
	 * Creates a new question object, sets the quiz question, four possible answer fields and indicates which one of them is the correct answer
	 * @param inputQ question string
	 * @param answerA possible answer string
	 * @param answerB possible answer string	
	 * @param answerC possible answer string	
	 * @param answerD possible answer string	
	 * @param correctAnswer char indicating which answer is correct	 
	 * @return Question
	 */
	Question createNewQuestion(String inputQ,String answerA,String answerB,String answerC,String answerD,char correctAnswer);

	/**
	 * Returns a new player quiz attempt object based on the quiz that corresponds to the quiz name passed to the method
	 * @param quizName
	 * @param playerName
	 * @return PlayerAttempt 
	 * @throws IllegalArgumentException
	 */
	PlayerAttempt getQuizAttempt(String quizName,String playerName);

	/**
	 * Returns the quiz corresponding to a particular quiz ID
	 * @param quizId
	 * @return Quiz 
	 */
	Quiz getQuiz(int quizId);

	/**
	 * Returns a list of the available quizzes a user can play
	 * @return List of string values representing the available quizzes a user can play
	 */
	List<String> getAvailableQuizList();

	/**
	 * Adds a mark to the players score 
	 * @param game a player attempt based on a certain quiz
	 * @throws IllegalArgumentException
	 */
	void addMarkToScore(PlayerAttempt game);

	/**
	 * Returns the player score for a particular player attempt of a quiz
	 * @param game a player attempt based on a certain quiz
	 * @return int value of the player score
	 * @throws IllegalArgumentException
	 */
	int getPlayerScore(PlayerAttempt game);

	/**
	 * Adds a new quiz to the quiz list and saves it to disk
	 * @param newQuiz
	 * @throws IllegalArgumentException
	 */
	void saveQuiz(Quiz newQuiz);

	/**
	 * Adds the result of a player attempt to the results list and saves it to disk
	 * @param game a player attempt
	 * @throws IllegalArgumentException
	 */
	void saveResult(PlayerAttempt game);
	
	/**
	 * Closes the quiz game referenced by a particular quiz ID and saves the quiz store to disk
	 * @param quizId
	 */
	void closeQuizGame(int quizId);
}






































