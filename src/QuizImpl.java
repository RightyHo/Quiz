import java.util.ArrayList;
import java.util.List;
import java.lang.NullPointerException;

public class QuizImpl {
	private List<Question> questionList;		//question list with no duplicates
	private List<Character> playerAnswers;		//stores answers to questions by players in the order they are received
	private int quizId;
	private String quizName;
	private int highScore;
	private String currentWinner;
	
	public QuizImpl(int Id){
		questionList = new ArrayList<Question>();
		playerAnswers = new ArrayList<Character>();
		quizId = Id;
		quizName = "";
		highScore = 0;
		currentWinner = "";
	}
	/**
	 * Add a question to the quiz
	 * Checks that there are no duplicates in the question list
	 * @param question object that contains possible answers and the correct answer
	 */
	public void addQuestion(String question){
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
	/**
	 * Records player answers in the playerAnswers list
	 * @param questionNumber connects the given answer to the relevant question in the quiz
	 * @param answer char a,b,c, or d relating to the multi-choice question
	 */
	public void recordAnswer(int questionNumber,char answer){
		try{
			playerAnswers.add(questionNumber,answer);
		} catch(NullPointerException ex){
			ex.printStackTrace();
		}
	}
	/**
	 * Returns quiz ID
	 * @return quizId
	 */
	public int getQuizId(){
		return quizId;
	}
	/**
	 * Sets the quiz name
	 * @param quizName String 
	 */
	public void setQuizName(Sting quizName){
		this.quizName = quizName;
	}
	/**
	 * Returns the quiz name
	 * @return String of the quiz name
	 */
	public String getQuizName(){
		return quizName;
	}
	/**
	 * Sets the highscore for this quiz
	 * @param highScore new high score for this quiz
	 */
	public void setHighScore(int highScore){
		this.highScore = highScore;
	}
	/**
	 * Returns the high score for this quiz
	 * @return highScore
	 */
	public int getHighScore(){
		return highScore;
	}
	/**
	 * Sets the name of the person with the current highest score for this quiz
	 * @param currentWinner the name of the person with the current highest score for this quiz
	 */
	public void setCurrentWinner(String currentWinner){
		this.currentWinner = currentWinner;
	}
	/**
	 * Gets the name of the person with the current highest score for this quiz
	 * @return currentWinner the name of the person with the current highest score for this quiz
	 */
	public String getCurrentWinner(){
		return currentWinner;
	}
}
