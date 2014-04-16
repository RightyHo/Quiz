package mach2;

public class QuizStoreImpl implements QuizStore,Serializable {
	List<Quiz> quizList;
	
	public QuizStoreImpl(){
		quizList = new ArrayList<Quiz>();
	}
}
