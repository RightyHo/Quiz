
public class QuestionImpl implements Question {
	private int questionId;
	private String question;
	private Answer possibleAnswers;
	
	public QuestionImpl(){
		possibleAnswers = new AnswerImpl();
		question = "";
		questionId = 0;
	}
	public QuestionImpl(int questionId,String question,String answerA,String answerB,String answerC,String answerD,char correctAnswer){
		this.questionId = questionId;
		this.question = question;
		this.possibleAnswers = new AnswerImpl(answerA,answerB,answerC,answerD,correctAnswer);
	}
	/**
	 * Returns question ID number
	 * @return question ID number
	 */
	public int getQuestionId(){
		return questionId;
	}
	/**
	 * Returns the question string
	 * @return question string
	 */
	public String getQuestion(){
		return question;
	}
	
}
