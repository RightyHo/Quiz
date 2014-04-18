package mach2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayerAttemptImpl implements PlayerAttempt, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2415700122129099939L;
	Quiz quiz;
	List<Character> playerAnswers;
	int playerScore;
	
	public PlayerAttemptImpl(Quiz quiz){
		this.quiz = quiz;
		playerAnswers = new ArrayList<Character>();
		playerScore = 0;
	}
	/**
	 * Returns the quiz question corresponding to the question number passed as parameter
	 * @param questionNumber
	 * @return Question
	 */
	public Question getQuestion(int questionNumber){
		return quiz.getQuestion(questionNumber);
	}
	/**
	 * Increments the player score by one
	 */
	public void addMarkToScore(){
		playerScore++;
	}
	/**
	 * Returns the player score
	 * @return int value of the player score
	 */
	public int getPlayerScore(){
		return playerScore;
	}
	/**
	 * Checks whether this player attempt is the new high score and adds the player score to the quiz results list  
	 */
	public void saveResult(){
		quiz.saveResult(playerScore);
	}
	/**
	 * Returns the quiz that this player attempt is based on
	 * @return Quiz that this player attempt is based on
	 */
	public Quiz getQuiz(){
		return quiz;
	}
}
