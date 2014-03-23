
public class QuestionImpl implements Question {
	private int questionId;
	private String question;
	private Set<Answer> possibleAnswers;
	
	public QuestionImpl(){
		possibleAnswers = new HashSet<Answer>();
		question = "";
		questionId = 0;
	}
	public QuestionImpl(int questionId,String question,Set<Answer> possibleAnswers){
		this.questionId = questionId;
		this.question = question;
		this.possibleAnswers = new HashSet<Answer>();
		this.possibleAnswers = possibleAnswers;
	}
	
}
