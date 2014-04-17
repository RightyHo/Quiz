package mach2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayerAttemptImpl implements PlayerAttempt, Serializable {
	Quiz quiz;
	List<Character> playerAnswers;
	int playerScore;
	
	public PlayerAttemptImpl(Quiz quiz){
		this.quiz = quiz;
		playerAnswers = new ArrayList<Character>();
		playerScore = 0;
	}
	
	public Question getQuestion(int questionNumber){
		return quiz.getQuestion(questionNumber);
	}
	
	public void addMarkToScore(){
		playerScore++;
	}
	
	public int getPlayerScore(){
		return playerScore;
	}
	
	public void saveResult(){
		quiz.saveResult(playerScore);
	}
}
