package mach2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuizStoreImpl implements QuizStore,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5418031766947696024L;
	List<Quiz> quizList;
	Quiz quiz;
	Question question;

	public QuizStoreImpl(){
		quizList = new ArrayList<Quiz>();
		quiz = null;
		question = null;
	}

	/**
	 * Creates a new Quiz
	 * @param quizName
	 * @return Quiz 
	 * @throws IllegalArgumentException
	 */
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

	/**
	 * Creates a new question object, sets the quiz question, four possible answer fields and indicates which one of them is the correct answer
	 * @param inputQ question string
	 * @param answerA possible answer string
	 * @param answerB possible answer string	
	 * @param answerC possible answer string	
	 * @param answerD possible answer string	
	 * @param correctAnswer char indicating which answer is correct	 
	 * @return Question
	 */
	public Question createNewQuestion(String inputQ,String answerA,String answerB,String answerC,String answerD,char correctAnswer){
		question = new QuestionImpl(inputQ,answerA,answerB,answerC,answerD,correctAnswer);
		return question;
	}

	/**
	 * Returns a new player quiz attempt object based on the quiz that corresponds to the quiz name passed to the method
	 * @param quizName
	 * @return PlayerAttempt 
	 * @throws IllegalArgumentException
	 */
	public PlayerAttempt getQuizAttempt(String quizName){
		PlayerAttempt result = null;
		if(quizName == null){
			throw new IllegalArgumentException();
		} else {
			for(Quiz q : quizList){
				if(q.getQuizName().equals(quizName)){
					result = new PlayerAttemptImpl(q);
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Returns the quiz corresponding to a particular quiz ID
	 * @param quizId
	 * @return Quiz 
	 */
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

	/**
	 * Returns a list of the available quizzes a user can play
	 * @return List of string values representing the available quizzes a user can play
	 */
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

	/**
	 * Adds a mark to the players score 
	 * @param game a player attempt based on a certain quiz
	 * @throws IllegalArgumentException
	 */
	public void addMarkToScore(PlayerAttempt game){
		if(game == null){
			throw new IllegalArgumentException();
		} else {
			game.addMarkToScore();
		}
	}

	/**
	 * Returns the player score for a particular player attempt of a quiz
	 * @param game a player attempt based on a certain quiz
	 * @return int value of the player score
	 * @throws IllegalArgumentException
	 */
	public int getPlayerScore(PlayerAttempt game){
		if(game == null){
			throw new IllegalArgumentException();
		} else {
			return game.getPlayerScore();
		}
	}

	/**
	 * Adds a new quiz to the quiz list and saves it to disk
	 * @param newQuiz
	 * @throws IllegalArgumentException
	 */
	public void saveQuiz(Quiz newQuiz){
		if(newQuiz.isQuizValid() == false){
			throw new IllegalArgumentException();
		} else{
			quizList.add(newQuiz);
		}
	}

	/**
	 * Adds the result of a player attempt to the results list and saves it to disk
	 * @param game a player attempt
	 * @throws IllegalArgumentException
	 */
	public void saveResult(PlayerAttempt game){
		if(game == null){
			throw new IllegalArgumentException();
		} else {
			game.saveResult();
		}
	}
	
	/**
	 * Closes the quiz game referenced by a particular quiz ID and saves the quiz store to disk
	 * @param quizId
	 */
	public void closeQuizGame(int quizId){
		for(Quiz q : quizList){
			if(q.getQuizId() == quizId){
				quizList.remove(q);
				break;
			}
		}
	}
}

























