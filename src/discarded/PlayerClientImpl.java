import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.Naming;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class PlayerClientImpl implements PlayerClient {
	public static void main(String[] args){
		//read imput string from console
		String para = args[0];
		PlayerClientImpl pc = new PlayerClientImpl();
		pc.launch(para);
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
			
			System.out.println("WELCOME TO THE QUIZ GAME:");
			boolean finished = false;
			int selection = 0;
			while(!finished){
				System.out.println("Please select an operation: ");
				System.out.println("To play a quiz enter (1): ");
				System.out.println("To exit this menu please enter (2): ");
				selection = Integer.parseInt(System.console().readLine());
				switch(selection){
				case 1:
					playQuiz(quizGameService);
					break;
				case 2:
					System.out.println("Thank you for playing.  Goodbye");
					finished = true;
					break;
				}
			}
		} catch (MalformedURLException ex){
			ex.printStackTrace();
		} catch (NotBoundException ex){
			ex.printStackTrace();
		} catch (RemoteException ex){
			ex.printStackTrace();
		}
	}
	
	private void playQuiz(QuizGameServer quizGameService) throws RemoteException{
		System.out.println("Please select a quiz from the available list below: ");
		List<String> sList = quizGameService.getAvaliableQuizList();
		for(String s : sList){
			System.out.println(s);
		}
		System.out.println("Please key in the name of the quiz you wish to play: ");
		String selection = System.console().readLine();
		Quiz game = quizGameService.getQuiz(selection);
		boolean finished = false;	
		int count = 1;
		Question printQuestion = null;
		while(!finished){	
			if(game.getQuizQuestions().getQuestion(count) != null){
				printQuestion = game.getQuizQuestions().getQuestion(count);
				System.out.println(printQuestion.getQuestion());
				System.out.println("A.)" + printQuestion.getAnswer('A'));
				System.out.println("B.)" + printQuestion.getAnswer('B'));
				System.out.println("C.)" + printQuestion.getAnswer('C'));
				System.out.println("D.)" + printQuestion.getAnswer('D'));
				selection = System.console().readLine();
				game.recordAnswer(count,selection.charAt(0));
				count++;
				if(printQuestion.getCorrectAnswer() == selection.charAt(0)){
					System.out.println("Correct!");
				} else {
					System.out.println("Incorrect.");
				}
			} else {
				finished = true;
			}
		}
		quizGameService.calculateScore(game);
	}
	
}























