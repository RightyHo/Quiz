package mach2;

public interface Quiz {

	int getQuizId();
	
	String getQuizName();
	
	String addQuestionToQuiz(Question newQuestion);
	
	Question getQuestion(int questionNumber);
	
	String getCurrentWinner();
	
	int getHighScore();
	
	boolean isQuizValid();
}
