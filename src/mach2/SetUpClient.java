package mach2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import mach2.Question;
import mach2.Quiz;
import mach2.QuizServer;


public class SetUpClient {
	private QuizServer quizService;
	private Quiz newQuiz;
	private Question newQuestion;
	private String quizName;
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	private char correctAnswer;

	public SetUpClient(){
		quizService = null;
		newQuiz = null;
		newQuestion = null;
		quizName = null;
		answerA = null;
		answerB = null;
		answerC = null;
		answerD = null;
		correctAnswer = '?';
	}

	public static void main(String[] args){
		//read imput string from console
		String para = args[0];
		SetUpClient su = new SetUpClient();
		su.launch(para);
	}
	private void launch(String str){
		// If there is no security manager, start one
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			Remote service = Naming.lookup("//127.0.0.1:1099/quiz");
			quizService = (QuizServer) service;

			String receivedEcho = quizService.echo(str);
			System.out.println("this is the received echo:  " + receivedEcho);
			
			System.out.println("QUIZ SET UP:");
			boolean finished = false;
			int selection = 0;
			while(!finished){
				System.out.println("Please select an operation: ");
				System.out.println("To create a new quiz enter (1): ");
				System.out.println("To close an existing quiz enter (2): ");
				System.out.println("To exit this menu please enter (3): ");
				selection = Integer.parseInt(System.console().readLine());
				switch(selection){
				case 1:
					createNewQuiz();
					break;
				case 2:
					System.out.println("Please key in the ID number of the quiz you wish to close: ");
					int id = Integer.parseInt(System.console().readLine());
					closeQuiz(id);
					break;
				case 3:
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
	/**
	 * Enable a user to create a new quiz 
	 * @throws RemoteException 
	 * @return the quiz ID number
	 */
	private int createNewQuiz() throws RemoteException{
		System.out.println("CREATE A NEW QUIZ:");
		System.out.println("Please key in the name of the new quiz: ");
		quizName = System.console().readLine();
		newQuiz = quizService.createNewQuiz(quizName);
		
		boolean finished = false;
		String inputQ = null;
		while(!finished){
			System.out.println("Please enter a new quiz question or type 'X' if the quiz list is complete:");
			inputQ = System.console().readLine();
			if(inputQ == "X" || inputQ == "x"){
				System.out.println("All quiz questions received.  Thanks you!");
				quizService.saveQuiz(newQuiz);
				finished = true;
				return newQuiz.getQuizId();
			} else {
				System.out.println("Please enter 'possible answer' A: ");
				answerA = System.console().readLine();
				System.out.println("Please enter 'possible answer' B: ");
				answerB = System.console().readLine();
				System.out.println("Please enter 'possible answer' C: ");
				answerC = System.console().readLine();
				System.out.println("Please enter 'possible answer' D: ");
				answerD = System.console().readLine();
				System.out.println("Now please key in the letter corresponding to the correct answer to this question (A,B,C or D): ");
				String temp = System.console().readLine();
				correctAnswer = temp.charAt(0);
				if(correctAnswer == 'A' || correctAnswer == 'B' || correctAnswer == 'C' || correctAnswer == 'D' ||
						correctAnswer == 'a' ||correctAnswer == 'b' ||correctAnswer == 'c' ||correctAnswer == 'd'){
					newQuestion = quizService.createNewQuestion(inputQ,answerA,answerB,answerC,answerD,correctAnswer);
					String outputQ = newQuiz.addQuestionToQuiz(newQuestion);
					System.out.println("QUESTION: " + outputQ + " has been added to the list.");
				} else {
					System.out.println("Error - the letter you input was out of bounds.  Please re-enter the question...");
				}
			}
		}
		return newQuiz.getQuizId();
	}

	private void closeQuiz(int quizId) throws RemoteException {
		Quiz quizToClose = quizService.getQuiz(quizId);
		String winner = quizToClose.getCurrentWinner();
		int allTimeHigh = quizToClose.getHighScore();
		quizName = quizToClose.getQuizName();
		quizService.closeQuizGame(quizId);
		System.out.println("CLOSING QUIZ: " + quizName);
		System.out.println("The Winner was: " + winner + " with an all time high score of " + allTimeHigh + "!");
	}
}


