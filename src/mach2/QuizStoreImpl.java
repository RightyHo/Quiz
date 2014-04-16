package mach2;

import java.util.List;

public class QuizStoreImpl implements QuizStore,Serializable {
	List<Quiz> quizList;
	Quiz quiz;
	Question question;
	
	public QuizStoreImpl(){
		quizList = new ArrayList<Quiz>();
		quiz = null;
		question = null;
	}
	
	public Quiz createNewQuiz(String quizName){
		if(quizList.isEmpty()){
			quiz = new QuizImpl(1,quizName);
		} else {
			quiz = new QuizImpl(quizList.size(),quizName);
		}
		return quiz;
	}
	
	public Question createNewQuestion(String inputQ,String answerA,String answerB,String answerC,String answerD,char correctAnswer){
		question = new QuestionImpl(inputQ,answerA,answerB,answerC,answerD,correctAnswer);
		return question;
	}
	
	public PlayerAttempt getQuiz(String quizName){
		return null;
	}
	
	public Quiz getQuiz(int quizId){
		return null;
	}
	
	public List<String> getAvailableQuizList(){
		return null;
	}
	
	public void addMarkToScore(PlayerAttempt game){
		game.addMarkToScore();
	}
}
