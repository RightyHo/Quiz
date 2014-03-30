
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface QuizGameServer extends Remote {
	/**
	 * Returns the same string passed as parameter etc
	 */
	String echo(String s) throws RemoteException;
	/**
	 * Create a new empty quiz and allocate it a quiz ID number
	 * @return Quiz a new empty quiz
	 */
	Quiz createEmptyQuiz() throws RemoteException;
	/**
	 * Adds a full quiz to the quizList
	 * @param fullQuiz a quiz that has been set up with all of its questions and suggested answers
	 */
	public void addFullQuizToList(Quiz fullQuiz);
	/**
	 * Closes the quiz game, quoting the game id. 
	 * The outcome will be a notification of the winner together with full player details (which should be persisted on the server).
	 * @param quizId quiz ID number
	 * @return winner name of the player who achieved the highest score on this quiz
	 */
	String closeQuizGame(int id) throws RemoteException;
	/**
	 * Calculates and returns the score of a completed quiz
	 * @return the number of correct answers 
	 */
	int calculateScore() throws RemoteException;
	/**
	 * Returns a list of the available quiz names
	 * @return quizList a list  of the available quiz names
	 */
	List<String> getAvaliableQuizList() throws RemoteException;
	/**
	 * Returns a quiz selected by name
	 * @param quizName the name of the chosen quiz 
	 */
	Quiz getQuiz(String quizName) throws RemoteException;
	/**
	 * Stores the high score of the quiz and the name of the current winner on disk
	 */
	void flush() throws RemoteException;
	
}
