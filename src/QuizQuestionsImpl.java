import java.util.ArrayList;
import java.util.List;


public class QuizQuestionsImpl implements QuizQuestions {
	private List<Question> questionList;
	private int quizId;
	private String quizName;

	public QuizQuestionsImpl(int id){
		questionList = new ArrayList<Question>();
		quizId = id;
		quizName = null;
	}

	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	/**
	 * Add a question to the quiz
	 * Checks that there are no duplicates in the question list
	 * @param question object that contains possible answers and the correct answer
	 */
	public void addQuestion(Question question){
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
	 * Returns question linked to the question number in the quiz
	 * @param questionNumber of the the question in the quiz
	 * @return question that was requested 
	 */
	public Question getQuestion(int questionNumber){
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
}
