import java.util.ArrayList;
import java.util.List;


public class QuizImpl {
	//question list with no duplicates
	private List<Question> questionList;
	private int quizId;
	private int highScore;
	
	public QuizImpl(int Id){
		questionList = new ArrayList<Question>();
		quizId = Id;
		highScore = 0;
	}
	/**
	 * Add a question to the quiz
	 * Checks that there are no duplicates in the question list
	 * @param question string
	 * @param answerList a list of possible answers including the correct answer
	 */
	public void addQuestion(String question){
		for(Question q : questionList){
			if(q.equals(question)){
				System.out.println("Error - you tried to enter a question that is already in the list");
			} else {
				questionList.add(question);
			}
		}
		
	}
	/**
	 * Returns the high score for this quiz
	 */
	public int getHighScore(){
		return highScore;
	}
	/**
	 * Returns quiz ID
	 */
	public int getQuizId(){
		return quizId;
	}
}
