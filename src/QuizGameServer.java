
import java.rmi.Remote;
import java.rmi.RemoteException;

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
	 * Closes the quiz game, quoting the game id. 
	 * The outcome will be a notification of the winner together with full player details (which should be persisted on the server).
	 * @param quizId quiz ID number
	 * @return winner name of the player who achieved the highest score on this quiz
	 */
	String closeQuizGame(int id) throws RemoteException;
}
