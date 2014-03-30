
public class QuestionImpl implements Question {
	private int questionId;
	private String question;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private char correctAnswer;
	
	public QuestionImpl(){
		questionId = 0;
		question = "";
		answerA = "";
		answerB = "";
		answerC = "";
		answerD = "";
		correctAnswer = '?';
	}
	public QuestionImpl(int questionId,String question,String answerA,String answerB,String answerC,String answerD,char correctAnswer){
		this.questionId = questionId;
		this.question = question;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.correctAnswer = correctAnswer;
	}
	/**
	 * Sets question ID number
	 * @param question ID number
	 */
	public void setQuestionId(int questionId){
		this.questionId = questionId;
	}
	/**
	 * Returns question ID number
	 * @return question ID number
	 */
	public int getQuestionId(){
		return questionId;
	}
	/**
	 * Sets the question string
	 * @param question a string
	 */
	public void setQuestion(String question){
		this.question = question;
	}
	/**
	 * Returns the question string
	 * @return question string
	 */
	public String getQuestion(){
		return question;
	}
	/**
	 * Sets the four possible answer fields and indicates which one of them is the correct answer
	 * @param answerA possible answer string
	 * @param answerB possible answer string	
	 * @param answerC possible answer string	
	 * @param answerD possible answer string	
	 * @param correctAnswer char indicating which answer is correct	 
	 */
	public void setAnswers(String answerA,String answerB,String answerC,String answerD,char correctAnswer){
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.correctAnswer = correctAnswer;
	}
}
