import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface QuizGameServer extends Remote {
	/**
	 * Returns the same string passed as parameter etc
	 */
	String echo(String s) throws RemoteException;
	/**
	 * Creates a new empty list of quiz questions and allocate it a random quiz ID number
	 * @return QuizQuestions a new empty quiz questions list
	 */
	QuizQuestions createEmptyQuizQuestionsList() throws RemoteException;
	/**
	 * Creates a new empty quiz with no player answers on it
	 * @param  quizQuestions a set of quiz questions with name & ID information included
	 * @return Quiz a quiz object to record player answers on 
	 */
	Quiz createQuiz(QuizQuestions quizQuestions);
	/**
	 * Adds a full quiz to the quizList
	 * @param fullQuiz a quiz that has been set up with all of its questions and suggested answers
	 * @return 
	 * @return Results creates and returns a new QuizResults object to store the quiz results	 
	 */
	QuizResults addFullQuizToList(Quiz fullQuiz) throws RemoteException;
	/**
	 * Closes the quiz game, quoting the game id. 
	 * The outcome will be a notification of the winner together with full player details (which should be persisted on the server).
	 * @param quizId quiz ID number
	 * @return winner name of the player who achieved the highest score on this quiz
	 */
	String closeQuizGame(int id) throws RemoteException;
	/**
	 * Calculates and returns the score of a completed quiz
	 * @param completedQuiz a completed quiz
	 * @return the number of correct answers 
	 */
	int calculateScore(Quiz completedQuiz) throws RemoteException;
	/**
	 * Returns a list of the available quiz names
	 * @return quizList a list  of the available quiz names
	 */
	List<String> getAvaliableQuizList() throws RemoteException;
	/**
	 * Returns a quiz selected by name
	 * @param quizName the name of the chosen quiz 
	 * @return the selected quiz or null if not found
	 */
	Quiz getQuiz(String quizName) throws RemoteException;
	/**
	 * Stores the high score of the quiz and the name of the current winner on disk
	 */
	void flush() throws RemoteException;	
}
