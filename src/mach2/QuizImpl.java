package mach2;

public class QuizImpl implements Quiz {
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
		highScorehighScore = 0;
		currentWinner = "";
	}
}
