package mach2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class QuizServerImpl extends UnicastRemoteObject implements QuizServer, Serializable{
	QuizStore quizStore;
	InputOutput io;
	
	public QuizServerImpl() throws RemoteException {
		io = new InputOutputImpl(fileName);
		if(io.fileAlreadyExists()){
			Object[] obj = io.readFromDisk();
			quizStore = (QuizStore) obj[0];
		} else {
			quizStore = new QuizStoreImpl();
		}
	}
	
	/**
	 * Saves the quizStore to disk
	 * @throws RemoteException
	 */
	public void flush() throws RemoteException{
		io.saveToDisk(quizStore);
	}
	
	public Quiz createNewQuiz(String quizName){
		return quizStore.createNewQuiz(quizName);
	}
	
	public Question createNewQuestion(String inputQ,String answerA,String answerB,String answerC,String answerD,char correctAnswer){
		return quizStore.createNewQuestion(inputQ,answerA,answerB,answerC,answerD,correctAnswer);
	}

	public Quiz getQuiz(int quizId){
		return quizStore.getQuiz(quizId);
	}
	
	public PlayerAttempt getQuiz(String quizName){
		return quizStore.getQuiz(quizName);
	}
	
	public List<String> getAvaliableQuizList(){
		return quizStore.getAvailableQuizList();
	}
	
	public void addMarkToScore(PlayerAttempt game){
		quizStore.addMarkToScore(game);
	}
	
	public int getPlayerScore(PlayerAttempt game){
		return quizStore.getPlayerScore(game);
	}
	
	public void saveQuiz(Quiz newQuiz){
		quizStore.saveQuiz(newQuiz);
		flush();
	}
	
	public void saveResult(int playerScore){
		quizStore.saveResult(playerScore);
		flush();
	}
	
	public void closeQuizGame(int quizId){
		quizStore.closeQuizGame(quizId);
		flush();
	}
	
	@Override
	public String echo(String s) throws RemoteException{
		System.out.println("Replied to a client saying '" + s + "'");
		return s;
	}	
}
