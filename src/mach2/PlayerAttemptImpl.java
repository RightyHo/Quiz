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
}
