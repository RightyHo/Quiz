import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;


public class SetUpClientImpl implements SetUpClient {
	public static void main(String[] args){
		//read imput string from console
		String para = args[0];
		SetUpClientImpl su = new SetUpClientImpl();
		su.launch(para);
	}
	private void launch(String str){
		// If there is no security manager, start one
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			Remote service = Naming.lookup("//127.0.0.1:1099/quiz");
			QuizGameServer quizGameService = (QuizGameServer) service;
			String receivedEcho = quizGameService.echo(str);
			System.out.println("this is the received echo:  " + receivedEcho);
		} catch (MalformedURLException ex){
			ex.printStackTrace();
		} catch (NotBoundException ex){
			ex.printStackTrace();
		} catch (RemoteException ex){
			ex.printStackTrace();
		}
	}
	/**
	 * Enable a user to create a new quiz 
	 * @param quizName for the quiz
	 * @param questionSet a set of questions
	 * @param possibleAnswers a set of possible answers for each question
	 * @return quizId a quiz game id
	 */
		public int createNewQuiz(String quizName,List<Question> questionList){
			return 0;
		}

	public String closeQuiz(int quizId) {
		return null;
	}
}
