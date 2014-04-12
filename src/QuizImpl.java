import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.lang.NullPointerException;

public class QuizImpl implements Quiz,Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	QuizQuestions quizQuestions;
	private List<Character> playerAnswers;	//stores answers to questions by players in the order they are received
	private int playerScore;
	//	private List<Question> questionList;	//question list with no duplicates	
	//	private int quizId;
	//	private String quizName;
	//	private int highScore;
	//	private String currentWinner;

	public QuizImpl(QuizQuestions quizQuestions){
		this.quizQuestions = quizQuestions;
		playerAnswers = new ArrayList<Character>();
		playerScore = 0;
		//		questionList = new ArrayList<Question>();
		//		quizId = Id;
		//		quizName = null;
		//		highScore = 0;
		//		currentWinner = null;
	}

	/**
	 * Returns quiz questions
	 * @return QuizQuestions an object containing a quiz questions list as well as name, ID, and answer information
	 */
	public QuizQuestions getQuizQuestions(){
		return quizQuestions;
	}
	/**
	 * Records player answers in the playerAnswers list
	 * @param questionNumber connects the given answer to the relevant question in the quiz
	 * @param answer char a,b,c, or d relating to the multi-choice question
	 */
	public void recordAnswer(int questionNumber,char answer){
		try{
			if(playerAnswers.size() >= questionNumber){
				playerAnswers.add(questionNumber,answer);
			} else {
				playerAnswers.add(answer);
			}
		} catch(NullPointerException ex){
			ex.printStackTrace();
		} catch(IllegalArgumentException ex){
			ex.printStackTrace();
			System.out.println("Error - illegal arguments");
		} catch(IndexOutOfBoundsException ex){
			ex.printStackTrace();
			System.out.println("Error - index is out of range");
		}
	}
	/**
	 * Returns the answer in the playerAnswers list
	 * @param questionNumber the question number of the player answer we are looking for
	 * @return char of the player answer stored for the question number
	 * @throws IndexOutOfBoundsException if questionNumber is outside of playerAnswers list range
	 */
	public Character getPlayerAnswer(int questionNumber){
		Character result = null;
		try{
			if(questionNumber < 0 || questionNumber > playerAnswers.size()-1){
				throw new IndexOutOfBoundsException();
			} else {
				result = playerAnswers.get(questionNumber);
				return result;
			}
		} catch (NullPointerException ex){
			System.out.println("Error - the playerAnswers list is null!");
		}
		return result;
	}
	/**
	 * Calculates and returns the score of a completed quiz
	 * updates results list with the score
	 * @return the number of correct answers
	 */
	public int calculatePlayerScore(){
		playerScore = 0;
		try{
			System.out.println("player answers " + playerAnswers.size());
			System.out.println("questions list " + quizQuestions.getQuestionList().size());
			if(playerAnswers.size() == quizQuestions.getQuestionList().size()){
				for(int i=0;i<quizQuestions.getQuestionList().size();i++){	
					System.out.println("player answer " + i + " is " + playerAnswers.get(i));
					System.out.println("correct answer " + i + " is " + quizQuestions.getQuestion(i).getCorrectAnswer());
					if(quizQuestions.getQuestion(i).getCorrectAnswer() == playerAnswers.get(i)){
						playerScore++;
					}
				}
				return playerScore;
			} else {
				System.out.println("You have not completed the quiz correctly. Please try again!");
				return -1;
			}
		} catch(NullPointerException ex){
			System.out.println("we got a null pointer on our hands!");
			ex.printStackTrace();
		} catch (IndexOutOfBoundsException ex){
			ex.printStackTrace();
			System.out.println("the question and answer numbers don't seem to be matching?");	
		}
		return playerScore;
	}	
	/**
	 * Add a question to the quiz
	 * Checks that there are no duplicates in the question list
	 * @param question object that contains possible answers and the correct answer
	 */
	/*	public void addQuestion(Question question){
		if(questionList.isEmpty()){
			questionList.add(question);
		} else {
			for(Question q : questionList){
				if(q.equals(question)){
					System.out.println("Error - you tried to enter a question that is already in the list");
					return;
				}	
			}
			questionList.add(question);
		}
	}
	 */	/**
	 * Returns question linked to the question number in the quiz
	 * @param questionNumber of the the quesion in the quiz
	 * @return the requested question
	 */
	/*	public Question getQuestion(int questionNumber){
		Question result = null;
		if(questionList.isEmpty()){
			System.out.println("The quiz is empty!");
			return result;
		} else{
			if(questionNumber < 1){
				System.out.println("The question number you requested is out of the bounds of this quiz");
			} else if(questionNumber <= questionList.size()){
				result = questionList.get(questionNumber -1);
			} else {
				System.out.println("The question number you requested is out of the bounds of this quiz");
			}
			return result;
		}
	}
	 */	/**
	 * Returns quiz ID
	 * @return quizId
	 */
	/*	public int getQuizId(){
		return quizId;
	}
	 */	/**
	 * Sets the quiz name
	 * @param quizName String
	 */
	/*	public void setQuizName(String quizName){
		this.quizName = quizName;
	}
	 */	/**
	 * Returns the quiz name
	 * @return String of the quiz name
	 */
	/*	public String getQuizName(){
		return quizName;
	}
	 */	/**
	 * Sets the highscore for this quiz
	 * @param highScore new high score for this quiz
	 */
	/*	public void setHighScore(int highScore){
		this.highScore = highScore;
	}
	 */	/**
	 * Returns the high score for this quiz
	 * @return highScore
	 */
	/*	public int getHighScore(){
		return highScore;
	}
	 */	/**
	 * Sets the name of the person with the current highest score for this quiz
	 * @param currentWinner the name of the person with the current highest score for this quiz
	 */
	/*	public void setCurrentWinner(String currentWinner){
		this.currentWinner = currentWinner;
	}
	 */	/**
	 * Gets the name of the person with the current highest score for this quiz
	 * @return currentWinner the name of the person with the current highest score for this quiz
	 */
	/*	public String getCurrentWinner(){
		return currentWinner;
	}
	 */	/**
	 * Returns the number of questions in the quiz
	 * @return int the number of questions in the quiz
	 */
	/*	public int getNumberOfQuestions(){
		int result = 0;
		result = questionList.size();
		return result;
	}
	 */	/**
	 * Returns a list of the results of the various user attempts on this quiz
	 * @return integer list representing the results all of the various user attempts on this quiz
	 */
	/*	public List<Integer> getResultsList(){
		return results;
	}
	 */	
}
