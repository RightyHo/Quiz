package mach2;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class QuizServerImpl extends UnicastRemoteObject implements QuizServer, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -602715859520900105L;
	private QuizStore quizStore;
	private InputOutput io;
	
	public QuizServerImpl(QuizStore quizStore,InputOutput io) throws RemoteException {
		this.io = io;				
		if(io.fileAlreadyExists()){
			Object[] obj = io.readFromDisk();
			this.quizStore = (QuizStore) obj[0];
		} else {
			this.quizStore = quizStore;
		}
	}
	
	/**
	 * Saves the quizStore to disk
	 * @throws RemoteException
	 */
	public void flush() throws RemoteException{
		io.saveToDisk(quizStore);
	}
	
	/**
	 * Creates a new quiz
	 * @param quizName
	 * @return Quiz
	 */
	public Quiz createNewQuiz(String quizName){
		return quizStore.createNewQuiz(quizName);
	}
	
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
	public Question createNewQuestion(String inputQ,String answerA,String answerB,String answerC,String answerD,char correctAnswer){
		return quizStore.createNewQuestion(inputQ,answerA,answerB,answerC,answerD,correctAnswer);
	}
	
	/**
	 * Returns the quiz corresponding to a particular quiz ID
	 * @param quizId
	 * @return Quiz 
	 */
	public Quiz getQuiz(int quizId){
		return quizStore.getQuiz(quizId);
	}
	
	/**
	 * Returns a new player quiz attempt object based on the quiz that corresponds to the quiz name passed to the method
	 * @param quizName
	 * @param playerName
	 * @return PlayerAttempt 
	 */
	public PlayerAttempt getQuizAttempt(String quizName,String playerName){
		return quizStore.getQuizAttempt(quizName,playerName);
	}
	
	/**
	 * Returns a list of the available quizzes a user can play
	 * @return List of string values representing the available quizzes a user can play
	 */
	public List<String> getAvaliableQuizList(){
		return quizStore.getAvailableQuizList();
	}
	
	/**
	 * Adds a mark to the players score 
	 * @param game a player attempt based on a certain quiz
	 */
	public void addMarkToScore(PlayerAttempt game){
		quizStore.addMarkToScore(game);
	}
	
	/**
	 * Returns the player score for a particular player attempt of a quiz
	 * @param game a player attempt based on a certain quiz
	 * @return int value of the player score
	 */
	public int getPlayerScore(PlayerAttempt game){
		return quizStore.getPlayerScore(game);
	}
	
	/**
	 * Adds a new quiz to the quiz list and saves it to disk
	 * @param newQuiz
	 * @throws RemoteException
	 */
	public void saveQuiz(Quiz newQuiz) throws RemoteException{
		quizStore.saveQuiz(newQuiz);
		flush();
	}
	
	/**
	 * Adds the result of a player attempt to the results list and saves it to disk
	 * @param game a player attempt
	 * @throws RemoteException
	 */
	public void saveResult(PlayerAttempt game) throws RemoteException{
		quizStore.saveResult(game);
		flush();
	}
	
	/**
	 * Closes the quiz game referenced by a particular quiz ID and saves the quiz store to disk
	 * @param quizId
	 * @throws RemoteException
	 */
	public void closeQuizGame(int quizId) throws RemoteException{
		quizStore.closeQuizGame(quizId);
		flush();
	}
	
	/**
	 * Dummy echo method for testing the RMI connection
	 */
	@Override
	public String echo(String s) throws RemoteException{
		System.out.println("Replied to a client saying '" + s + "'");
		return s;
	}	
}














