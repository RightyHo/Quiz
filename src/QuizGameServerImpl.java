import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class QuizGameServerImpl extends UnicastRemoteObject implements QuizGameServer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Quiz> quizList;
	private List<QuizResults> resultsList;
//	private List<Character> playerAnswers;		//stores answers to questions by players in the order they are received
	
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
		double randomNumber = Math.random();
		double d = randomNumber * 100;
		//Type cast double to int
		int quizId = (int)d + 1;
		Quiz emptyQuiz = new QuizImpl(quizId);
		return emptyQuiz;
	}
	/**
	 * Adds a full quiz to the quizList
	 * @param fullQuiz a quiz that has been set up with all of its questions and suggested answers
	 * @return 
	 * @return Results creates and returns a new QuizResults object to store the quiz results	 
	 */
	public QuizResults addFullQuizToList(Quiz fullQuiz) throws RemoteException{
		QuizResults quizResults = null;
		//check that quiz has been set up correctly
		if(fullQuiz.getQuizName()!=null){
			if(fullQuiz.getQuestion(1)!= null){
				quizList.add(fullQuiz);
				quizResults = new QuizResultsImpl(fullQuiz.getQuizId());
			}
		}
		return quizResults;
	}
	/**
	 * Closes the quiz game, quoting the game id. 
	 * The outcome will be a notification of the winner together with full player details (which should be persisted on the server).
	 * @param quizId quiz ID number
	 * @return winner name of the player who achieved the highest score on this quiz or null if the quiz ID is not valid
	 */
	public String closeQuizGame(int id) throws RemoteException{
		String result = null;
		for(int i=0;i<quizList.size();i++){
			if(quizList.get(i).getQuizId() == id){
				result = quizList.get(i).getCurrentWinner();
				String qName = quizList.get(i).getQuizName();
				int qScore = quizList.get(i).getHighScore();
				System.out.println("The winner of the "+ qName + " quiz is " + result + " with a high score of " + qScore);
				quizList.remove(i);
			}
		}
		return result;
	}
	/**
	 * Calculates and returns the score of a completed quiz
	 * @param completedQuiz a completed quiz
	 * @return the number of correct answers 
	 */
	public int calculateScore(Quiz completedQuiz) throws RemoteException{
		int result = 0;
		if(completedQuiz == null){
			System.out.println("Error - The quiz you passed was null!");
			return result;
		} else {
			try{
				result = completedQuiz.calculatePlayerScore();
			} catch(NullPointerException ex){
				ex.printStackTrace();
			} catch (IndexOutOfBoundsException ex){
				ex.printStackTrace();
				System.out.println("the question and answer numbers don't seem to be matching?");				
			}
		}
		return result;
	}
	/**
	 * Returns a list of the available quiz names
	 * @return quizList a list  of the available quiz names
	 */
	public List<String> getAvaliableQuizList() throws RemoteException{
		List<String> result = new ArrayList<String>();
		try {
			for(Quiz q : quizList){
				result.add(q.getQuizName());
			}
		} catch(NullPointerException ex){
			ex.printStackTrace();
			System.out.println("encountered a null pointer when using quizList");
		}
		return result;
	}
	/**
	 * Returns a quiz selected by name
	 * @param quizName the name of the chosen quiz 
	 * @return the selected quiz or null if not found
	 */
	public Quiz getQuiz(String quizName) throws RemoteException{
		Quiz result = null;
		if(quizName == null){
			System.out.println("Error - the quiz name you requested was null");
			return result;
		} else {
			for(Quiz q : quizList){
				if(q.getQuizName().equals(quizName)){
					result = q;
					return result;
				}
			}
		}
		return result;
	}
	/**
	 * Stores the high score of the quiz and the name of the current winner on disk
	 */
	public void flush() throws RemoteException{
		File file = new File("quizFile.ser"); 
		ObjectOutputStream out = null;
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(file);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(quizList);
			System.out.printf("Serialized data is saved in quizFile.ser");
		} catch(FileNotFoundException ex) {
		// This happens if file does not exist and cannot be created, 
		// or if it exists, but is not writable 
			System.out.println("Cannot write to file " + file + ".");
		} catch(IOException ex) { 
			ex.printStackTrace();
	    } finally {
	        closeWriter(out,fileOut);
		}
	}
	private void closeWriter(ObjectOutputStream out,FileOutputStream fileOut) { 
		try {
			if(out != null) { 
				out.close();
			}
			if(fileOut != null) { 
				fileOut.close();
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}































