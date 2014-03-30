import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class QuizGameServerImpl extends UnicastRemoteObject implements QuizGameServer {
	private List<Quiz> quizList;
	
	public QuizGameServerImpl() throws RemoteException {
		quizList = new ArrayList<Quiz>();
	}
	@Override
	public String echo(String s){
		System.out.println("Replied to a client saying '" + s + "'");
		return s;
	}
	/**
	 * Create a new empty quiz and allocate it a random quiz ID number
	 * @return Quiz a new empty quiz
	 */
	public Quiz createEmptyQuiz() throws RemoteException{
		//Create random quiz ID number 1 - 100
		double randNumber = Math.random();
		double d = randNumber * 100;
		//Type cast double to int
		int quizId = (int)d + 1;
		Quiz emptyQuiz = new QuizImpl(quizId);
		return emptyQuiz;
	}
	/**
	 * Adds a full quiz to the quizList
	 * @param fullQuiz a quiz that has been set up with all of its questions and suggested answers
	 */
	public void addFullQuizToList(Quiz fullQuiz){
		//check that quiz has been set up correctly
		if(fullQuiz.getQuizName()!=null){
			if(fullQuiz.getQuestion(1)!= null){
				quizList.add(fullQuiz);
			}
		}
	}
	/**
	 * Closes the quiz game, quoting the game id. 
	 * The outcome will be a notification of the winner together with full player details (which should be persisted on the server).
	 * @param quizId quiz ID number
	 * @return winner name of the player who achieved the highest score on this quiz
	 */
	public String closeQuizGame(int id) throws RemoteException{
		return null;
	}
	/**
	 * Calculates and returns the score of a completed quiz
	 * @return the number of correct answers 
	 */
	public int calculateScore() throws RemoteException{
		return 0;
	}
	/**
	 * Returns a list of the available quiz names
	 * @return quizList a list  of the available quiz names
	 */
	public List<String> getAvaliableQuizList() throws RemoteException{
		return null;
	}
	/**
	 * Returns a quiz selected by name
	 * @param quizName the name of the chosen quiz 
	 */
	public Quiz getQuiz(String quizName) throws RemoteException{
		return null;
	}
	/**
	 * Stores the high score of the quiz and the name of the current winner on disk
	 */
	public void flush() throws RemoteException{
		//add code
	}
}
