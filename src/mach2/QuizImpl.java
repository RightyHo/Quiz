package mach2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuizImpl implements Quiz,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5327550892892727172L;
	int quizId;
	String quizName;
	List<Question> questionList;
	List<Integer> playerResultsList;
	int highScore;
	String currentWinner;
	
	public QuizImpl(int quizId,String quizName){
		this.quizId = quizId;
		this.quizName = quizName;
		questionList = new ArrayList<Question>();
		playerResultsList = new ArrayList<Integer>();
		highScore = 0;
		currentWinner = "";
	}
	
	/**
	 * Returns the quiz ID
	 * @param int value representing the quiz ID
	 */
	public int getQuizId(){
		return quizId;
	}
	
	/**
	 * Returns the Quiz Name
	 * @return String of the quiz name
	 */
	public String getQuizName(){
		return quizName;
	}
	
	/**
	 * Adds a question to the quiz question list
	 * @param newQuestion
	 * @return String of the new quiz question that has been added to the list
	 * @throws IllegalArgumentException
	 */
	public String addQuestionToQuiz(Question newQuestion){
		String result = null;
		if(!newQuestion.isQuestionValid()){
			throw new IllegalArgumentException();
		} else {
			questionList.add(newQuestion);
			result = newQuestion.getQuestion();
		}
		return result;
	}
	
	/**
	 * Returns the question related to the question number passed to the method
	 * @param questionNumber 
	 * @return Question
	 * @throws IndexOutOfBoundsException
	 */
	public Question getQuestion(int questionNumber){
		Question result = null;
		if(questionNumber > questionList.size()){
			throw new IndexOutOfBoundsException();
		} else {
			result = questionList.get(questionNumber-1);
		}
		return result;
	}
	
	/**
	 * returns the current winner of the quiz
	 * @return String of the current winner of the quiz
	 */
	public String getCurrentWinner(){
		return currentWinner;
	}
	
	/**
	 * returns the current high score of the quiz
	 * @return int value of the current high score of the quiz
	 */
	public int getHighScore(){
		return highScore;
	}
	
	/**
	 * Checks whether the quiz is set up correctly with a quiz ID and name
	 * @return boolean value of true if the quiz is valid or false if it is not
	 */
	public boolean isQuizValid(){
		boolean result = true;
		if(quizId == 0){
			result = false;
		}
		if(quizName == null){
			result = false;
		}
		return result;
	}
	
	/**
	 * Adds the player score to the quiz results list.  Checks whether this player score is the new high score and
	 * if so requests the players name and stores the input with the quiz record
	 * @param playerScore
	 */
	public void saveResult(int playerScore){
		playerResultsList.add(playerScore);
		if(playerScore > highScore){
			highScore = playerScore;
			System.out.println("Congratulations you have the highest score so far!  For posterity's sake please sign your name:");
			currentWinner = System.console().readLine();
		}
	}
}




























































