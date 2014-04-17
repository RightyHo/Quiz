package mach2;

import java.rmi.RemoteException;
import java.util.List;

public interface QuizServer {
	/**
	 * Saves the quizStore to disk
	 * @throws RemoteException
	 */
	void flush() throws RemoteException;
	
	Quiz createNewQuiz(String quizName);
	
	Question createNewQuestion(String inputQ,String answerA,String answerB,String answerC,String answerD,char correctAnswer);

	Quiz getQuiz(int quizId);
	
	PlayerAttempt getQuiz(String quizName);
	
	List<String> getAvaliableQuizList();
	
	void addMarkToScore(PlayerAttempt game);
	
	int getPlayerScore(PlayerAttempt game);
	
	void saveQuiz(Quiz newQuiz) throws RemoteException;
	
	void saveResult(PlayerAttempt game) throws RemoteException;
	
	void closeQuizGame(int quizId) throws RemoteException;
	
	String echo(String s) throws RemoteException;
}
