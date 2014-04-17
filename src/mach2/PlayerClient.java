package mach2;

import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.Naming;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class PlayerClient {
	QuizServer quizGameService;
	PlayerAttempt game;
	Question printQuestion;

	public PlayerClient(){
		quizGameService = null;
		game = null;
		printQuestion = null;
	}
	public static void main(String[] args){
		//read imput string from console
		String para = args[0];
		PlayerClient pc = new PlayerClient();
		pc.launch(para);
	}
	private void launch(String str){
		// If there is no security manager, start one
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			Remote service = Naming.lookup("//127.0.0.1:1099/quiz");
			quizGameService = (QuizServer) service;
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
					playQuiz();
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

	private void playQuiz() throws RemoteException{
		System.out.println("Please select a quiz from the available list below: ");
		List<String> sList = quizGameService.getAvaliableQuizList();
		for(String s : sList){
			System.out.println(s);
		}
		System.out.println("Please key in the name of the quiz you wish to play: ");
		String selection = System.console().readLine();
		game = quizGameService.getQuiz(selection);
		if(game.getQuiz().validQuiz() = false){
			System.out.println("Error -  you cannot play an invalid quiz!");
		} else {
			boolean finished = false;	
			int count = 1;
			while(!finished){	
				if(game.getQuestion(count) != null){
					printQuestion = game.getQuestion(count);
					System.out.println(printQuestion.getQuestion());
					System.out.println("A.)" + printQuestion.getAnswer('A'));
					System.out.println("B.)" + printQuestion.getAnswer('B'));
					System.out.println("C.)" + printQuestion.getAnswer('C'));
					System.out.println("D.)" + printQuestion.getAnswer('D'));
					selection = System.console().readLine();
					if(selection != null){
						if(selection.charAt(0) == printQuestion.getCorrectAnswer()){
							quizGameService.addMarkToScore(game);
							System.out.println("Correct!");
						} else {
							System.out.println("Incorrect.");
						}
					} else {
						System.out.println("Error - Your answer to question " + count + "was null!");
					}
					count++;
			}
			int playerScore = quizGameService.getPlayerScore(game);
			System.out.println("Your total score was: " + playerScore);
			quizGameService.saveResult(game);
		}

	}
























