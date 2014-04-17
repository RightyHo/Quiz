package mach2;

import java.util.ArrayList;
import java.util.List;

public interface QuizStore {
	Quiz createNewQuiz(String quizName);
	
	Question createNewQuestion(String inputQ,String answerA,String answerB,String answerC,String answerD,char correctAnswer);
	
	PlayerAttempt getQuiz(String quizName);

	Quiz getQuiz(int quizId);

	List<String> getAvailableQuizList();

	void addMarkToScore(PlayerAttempt game);

	int getPlayerScore(PlayerAttempt game);

	void saveQuiz(Quiz newQuiz);

	void saveResult(PlayerAttempt game,int playerScore);

	void closeQuizGame(int quizId);
}
