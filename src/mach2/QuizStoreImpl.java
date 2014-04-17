package mach2;

import java.io.Serializable;
import java.util.ArrayList;
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
		if(quizName == null){
			throw new IllegalArgumentException();
		} else {
			if(quizList.isEmpty()){
				quiz = new QuizImpl(1,quizName);
			} else {
				quiz = new QuizImpl(quizList.size(),quizName);
			}
		}
		return quiz;
	}

	public Question createNewQuestion(String inputQ,String answerA,String answerB,String answerC,String answerD,char correctAnswer){
		question = new QuestionImpl(inputQ,answerA,answerB,answerC,answerD,correctAnswer);
		return question;
	}

	public PlayerAttempt getQuiz(String quizName){
		Quiz result = null;
		if(quizName == null){
			throw new IllegalArgumentException();
		} else {
			for(Quiz q : quizList){
				if(q.getQuizName().equals(quizName)){
					result = q;
					break;
				}
			}
		}
		return result;
	}

	public Quiz getQuiz(int quizId){
		Quiz result = null;
		for(Quiz q : quizList){
			if(q.getQuizId() == quizId){
				result = q;
				break;
			}
		}
		return result;
	}

	public List<String> getAvailableQuizList(){
		List<String> result = new ArrayList<String>();
		if(quizList.isEmpty()){
			result = null;
		} else {
			for(Quiz q : quizList){
				result.add(q.getQuizName());
			}
		}
		return result;
	}

	public void addMarkToScore(PlayerAttempt game){
		if(game == null){
			throw new IllegalArgumentException();
		} else {
			game.addMarkToScore();
		}
	}

	public int getPlayerScore(PlayerAttempt game){
		if(game == null){
			throw new IllegalArgumentException();
		} else {
			return game.getPlayerScore();
		}
	}

	public void saveQuiz(Quiz newQuiz){
		if(newQuiz.isQuizValid() == false){
			throw new IllegalArgumentException();
		} else{
			quizList.add(newQuiz);
		}
	}

	public void saveResult(PlayerAttempt game,int playerScore){
		if(game == null){
			throw new IllegalArgumentException();
		} else {
			game.saveResult(playerScore);
		}
	}

	public void closeQuizGame(quizId){
		for(Quiz q : quizList){
			if(q.getQuizId() == quizId){
				quizList.remove(q);
				break;
			}
		}
	}
}

























