package mach2;

public class PlayerAttemptImpl implements PlayerAttempt {
	Quiz quiz;
	List<Char> playerAnswers;
	int playerScore;
	
	public PlayerAttemptImpl(Quiz quiz){
		this.quiz = quiz;
		playerAnswers = new ArrayList<Char>();
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
