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
	
	public int getQuizId(){
		return quizId;
	}
	
	public String getQuizName(){
		return quizName;
	}
	
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
	
	public Question getQuestion(int questionNumber){
		Question result = null;
		if(questionNumber > questionList.size()){
			throw new IndexOutOfBoundsException();
		} else {
			result = questionList.get(questionNumber-1);
		}
		return result;
	}
	
	public String getCurrentWinner(){
		return currentWinner;
	}
	
	public int getHighScore(){
		return highScore;
	}
	
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
	
	public void saveResult(int playerScore){
		playerResultsList.add(playerScore);
	}
}
