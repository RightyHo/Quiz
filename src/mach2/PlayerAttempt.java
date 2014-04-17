package mach2;

public interface PlayerAttempt {

	Question getQuestion(int questionNumber);
	
	void addMarkToScore();
	
	int getPlayerScore();
	
	void saveResult();

}
