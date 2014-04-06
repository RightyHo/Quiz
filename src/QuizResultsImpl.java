import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class QuizResultsImpl implements QuizResults, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int quizId;
	private List<Integer> userResultsList;
	private int highScore;
	private String currentWinner;
	
	public QuizResultsImpl(int quizId){
		this.quizId = quizId;
		userResultsList = new ArrayList<Integer>();
		highScore = 0;
		currentWinner = null;
	}
	/**
	 * gets the quiz ID number
	 * @return int the quiz ID number
	 */
	public int getQuizId(){
		return quizId;
	}
	/**
	 * Returns a list of the results of the various user attempts on this quiz
	 * @return an integer list of the results of the various user attempts on this quiz
	 */
	public List<Integer> getUserResultsList(){
		return userResultsList;
	}
	/**
	 * Adds a new user result to the user results list
	 * @param score the new user result to add the user results list
	 */
	public void addUserResult(int score){
		if(score > highScore){
			System.out.println("Congratulations, you currently have the highest score for this quiz!  Please key in your name: ");
			currentWinner = System.console().readLine();
			highScore = score;
			userResultsList.add(score);
		} else {
			userResultsList.add(score);
		}
	}
	/**
	 * Returns the highest score on the quiz 
	 * @return int showing the highest score on the quiz 
	 */
	public int getHighScore() {
		return highScore;
	}
	/**
	 * Returns the name of the current winner of this quiz game
	 * @return string of the name of the current winner of this quiz game
	 */
	public String getCurrentWinner() {
		return currentWinner;
	}
}
