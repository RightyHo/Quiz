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
	private List<QuizQuestions> questionsList;
	private InputOutput io;
	private static final String fileName = "quizFile.ser";

	public QuizGameServerImpl() throws RemoteException {
		quizList = new ArrayList<Quiz>();
		io = new InputOutputImpl(fileName);
		if(io.fileAlreadyExists()){
			Object[] obj = io.readFromDisk();
			resultsList = (List<QuizResults>) obj[0];
			questionsList = (List<QuizQuestions>) obj[1];
		} else {
			resultsList = new ArrayList<QuizResults>();
			questionsList = new ArrayList<QuizQuestions>();
		}
	}
	@Override
	public String echo(String s) throws RemoteException{
		System.out.println("Replied to a client saying '" + s + "'");
		return s;
	}
	/**
	 * Creates a new questions list object and populates the object with the questions, answers and quiz name
	 * @param quizName 
	 * @param question 
	 * @param answerA possible answer
	 * @param answerB possible answer
	 * @param answerC possible answer
	 * @param answerD possible answer
	 * @param correctAnswer 
	 * @return String of the question originally passed as a parameter  
	 */
	public String populateQuestion(String quizName,String question,String answerA,String answerB,String answerC,String answerD,char correctAnswer) throws RemoteException{
		Question newQuestion = new QuestionImpl(question,answerA,answerB,answerC,answerD,correctAnswer);
		//Check if the a quiz question list with this quizName already exists
		for(QuizQuestions qq : questionsList){
			if(qq.getQuizName().equals(quizName)){
				qq.addQuestion(newQuestion);
				return question;
			}
		}
		QuizQuestions newQuizQuestionsList = createQuizQuestionsList();
		newQuizQuestionsList.setQuizName(quizName);
		newQuizQuestionsList.addQuestion(newQuestion);
		addQuizQuestionsToList(newQuizQuestionsList);
		return question;
	}
	/**
	 * Creates a new empty list of quiz questions and allocate it a random quiz ID number
	 * @return QuizQuestions a new empty quiz questions list
	 */
	public QuizQuestions createQuizQuestionsList() throws RemoteException{
		//Create random quiz ID number 1 - 100
		double randomNumber = Math.random();
		double d = randomNumber * 100;
		//Type cast double to int
		int quizId = (int)d + 1;
		QuizQuestions emptyQuizQuestions = new QuizQuestionsImpl(quizId);
		return emptyQuizQuestions;
	}
	/**
	 * Checks that a quiz questions object is complete and adds it to the questionsList
	 * @param fullQuizQuestions a complete quiz questions object with quizName set and at least one question
	 */
	public void addQuizQuestionsToList(QuizQuestions fullQuizQuestions) throws RemoteException{
		try{
			if(fullQuizQuestions.getQuizName() == null){
				System.out.println("Error - the quiz name hasn't been set, this QuizQuestions object hasn't been completely set up yet!");
				return;
			} else if(fullQuizQuestions.getQuestion(1) == null){
				System.out.println("Error - the quiz questions haven't been set, this QuizQuestions object hasn't been completely set up yet!");
				return;
			} else {
				questionsList.add(fullQuizQuestions);
			}
		} catch (NullPointerException ex){
			ex.printStackTrace();
			System.out.println("Error - The quiz questions you passed were null!");
		}
	}
	/**
	 * Creates a new empty quiz with no player answers on it
	 * @param  quizQuestions a set of quiz questions with name & ID information included
	 * @return Quiz a quiz object to record player answers on 
	 */
	public Quiz createQuiz(QuizQuestions quizQuestions) throws RemoteException{
		Quiz unansweredQuiz  = new QuizImpl(quizQuestions);
		return unansweredQuiz;
	}
	/**
	 * Adds a full quiz to the quizList and also adds a corresponding QuizResults object to the resultsList
	 * @param fullQuiz a quiz that has been set up with all of its questions and suggested answers
	 * @return QuizResults creates and returns a new QuizResults object to store the quiz results
	 */
	public QuizResults addFullQuizToList(Quiz fullQuiz) throws RemoteException{
		QuizResults quizResults = null;
		//check that quiz has been set up correctly
		if(fullQuiz.getQuizQuestions().getQuizName()!=null){
			if(fullQuiz.getQuizQuestions().getQuestion(1)!= null){
				quizList.add(fullQuiz);
				quizResults = new QuizResultsImpl(fullQuiz.getQuizQuestions().getQuizId());
				resultsList.add(quizResults);
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
		String qWinner = null;
		String qName = null;
		int qScore = 0;

		for(int i=0;i<resultsList.size();i++){
			if(resultsList.get(i).getQuizId() == id){
				qWinner = resultsList.get(i).getCurrentWinner();
				qScore = resultsList.get(i).getHighScore();
			}
		}
		for(int i=0;i<quizList.size();i++){
			if(quizList.get(i).getQuizQuestions().getQuizId() == id){
				qName = quizList.get(i).getQuizQuestions().getQuizName();
				quizList.remove(i);
			}
		}
		System.out.println("The winner of the "+ qName + " quiz is " + qWinner + " with a high score of " + qScore);
		flush();
		return qWinner;
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
				result.add(q.getQuizQuestions().getQuizName());
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
				if(q.getQuizQuestions().getQuizName().equals(quizName)){
					result = q;
					return result;
				}
			}
		}
		return result;
	}
	/**
	 * Saves the results list and questions list to disk
	 * @throws RemoteException
	 */
	public void flush() throws RemoteException{
		io.saveToDisk(resultsList, questionsList);
	}
}
