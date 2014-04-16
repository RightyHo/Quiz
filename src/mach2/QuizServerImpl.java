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
	
	Quiz createNewQuiz(String quizName){
		return quizStore.createNewQuiz(quizName);
	}
	
	Question createNewQuestion(inputQ,answerA,answerB,answerC,answerD,correctAnswer){
		return 
	}

	List<String> getAvaliableQuizList(){
		return quizStore.getAvailableQuizList();
	}
	
	PlayerAttempt quizGameService.getQuiz(String quizName){
		return quizStore.getQuiz(quizName);
	}
	
	/**
	 * Saves the quizStore to disk
	 * @throws RemoteException
	 */
	public void flush() throws RemoteException{
		io.saveToDisk(quizStore);
	}
	
	@Override
	public String echo(String s) throws RemoteException{
		System.out.println("Replied to a client saying '" + s + "'");
		return s;
	}	
}
