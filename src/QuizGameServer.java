import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface QuizGameServer extends Remote {
	/**
	 * Echo method
	 * @param s
	 * @return
	 */
	String echo(String s);
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
	String populateQuestion(String quizName,String question,String answerA,String answerB,String answerC,String answerD,char correctAnswer);
	/**
	 * Creates a new empty list of quiz questions and allocate it a random quiz ID number
	 * @return QuizQuestions a new empty quiz questions list
	 */
	QuizQuestions createQuizQuestionsList();
	/**
	 * Checks that a quiz questions object is complete and adds it to the questionsList
	 * @param fullQuizQuestions a complete quiz questions object with quizName set and at least one question
	 */
	void addQuizQuestionsToList(QuizQuestions fullQuizQuestions);
	/**
	 * Creates a new empty quiz with no player answers on it
	 * @param  quizQuestions a set of quiz questions with name & ID information included
	 * @return Quiz a quiz object to record player answers on 
	 */
	Quiz createQuiz(QuizQuestions quizQuestions);
	/**
	 * Adds a full quiz to the quizList and also adds a corresponding QuizResults object to the resultsList
	 * @param fullQuiz a quiz that has been set up with all of its questions and suggested answers
	 * @return QuizResults creates and returns a new QuizResults object to store the quiz results
	 */
	QuizResults addFullQuizToList(Quiz fullQuiz) throws RemoteException;
	/**
	 * Closes the quiz game, quoting the game id. 
	 * The outcome will be a notification of the winner together with full player details (which should be persisted on the server).
	 * @param quizId quiz ID number
	 * @return winner name of the player who achieved the highest score on this quiz or null if the quiz ID is not valid
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
	}