
public class AnswerImpl implements Answer {
	private int questionId;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private char correctAnswer;
	
	public AnswerImpl(){
		questionId = 0;
		answerA = "";
		answerB = "";
		answerC = "";
		answerD = "";
		correctAnswer = '?';
	}
	public AnswerImpl(int questionId,String answerA,String answerB,String answerC,String answerD,char correctAnswer){
		this.questionId = questionId;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.correctAnswer = correctAnswer;
	}
}
