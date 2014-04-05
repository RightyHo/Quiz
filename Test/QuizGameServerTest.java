import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class QuizGameServerTest {
	QuizGameServer server;
	Quiz quizOutput;
	String strOutput;
	String strExpected;
	int intOutput;
	int intExpected;

	@Before
	public void setUp() throws Exception {
		server = new QuizGameServerImpl();
		quizOutput = null;
		strOutput = "";
		strExpected = "";
		intOutput = 0;
		intExpected = 0;
		buildQuizList();
	}
	/**
	 * Builds a quiz list to test 
	 * @throws RemoteException
	 */
	private void buildQuizList() throws RemoteException {
		Quiz q1 = new QuizImpl(821);
		Quiz q2 = new QuizImpl(921);
		Quiz q3 = new QuizImpl(421);
		q1.setQuizName("testQ1");
		q2.setQuizName("testQ2");
		q3.setQuizName("testQ3");
		Question test1 = Mockito.mock(Question.class);
		Question test2 = Mockito.mock(Question.class);
		Question test3 = Mockito.mock(Question.class);
		q1.addQuestion(test1);
		q2.addQuestion(test2);
		q3.addQuestion(test3);
		// define return value for method getQuestion()
		Mockito.when(test1.getQuestion()).thenReturn("Test 1 quetion?");
		Mockito.when(test2.getQuestion()).thenReturn("Test 2 quetion?");
		Mockito.when(test3.getQuestion()).thenReturn("Test 3 quetion?");
		q1.setHighScore(8);
		q2.setHighScore(6);
		q3.setHighScore(4);
		q1.setCurrentWinner("Jamie");
		q2.setCurrentWinner("Wade");
		q3.setCurrentWinner("Travis");
		server.addFullQuizToList(q1);
		server.addFullQuizToList(q2);
		server.addFullQuizToList(q3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateEmptyQuiz() throws RemoteException{
		//check that quiz is not null
		quizOutput = server.createEmptyQuiz();
		assertNotNull(quizOutput);
		//check that the quiz ID is between 1-100
		intOutput = quizOutput.getQuizId();
		assertTrue(intOutput > 0);
		assertTrue(intOutput <= 100);
		//check that the quiz name is null --> it is an empty quiz
		strOutput = quizOutput.getQuizName();
		assertNull(strOutput);
	}
	/**
	 * Tests addFullQuizToList() and getQuiz() methods
	 */
	@Test
	public void testAddFullQuizToList() throws RemoteException{
		Quiz fullQuiz = new QuizImpl(321);
		fullQuiz.setQuizName("Balls of String");
		Question mockQuestion = Mockito.mock(Question.class);
		fullQuiz.addQuestion(mockQuestion);
		// define return value for method getQuestion()
		Mockito.when(mockQuestion.getQuestion()).thenReturn("How long is a ball of string?");
		server.addFullQuizToList(fullQuiz);
		quizOutput = server.getQuiz("Balls of String");
		assertEquals(fullQuiz,quizOutput);
	}

	@Test
	public void testCloseQuizGame() throws RemoteException{
		try{
			List<String> listOutput = server.getAvaliableQuizList();
			for(String s : listOutput){
				System.out.println(s);
			}
			intOutput = listOutput.size();
			strOutput = server.closeQuizGame(421);
			listOutput = server.getAvaliableQuizList();
			for(String s : listOutput){
				System.out.println(s);
			}
			int listSize = listOutput.size();
			assertEquals(listSize,intOutput-1);
		} catch(NullPointerException ex){
			ex.printStackTrace();
			System.out.println("Error - the quiz list is null!");
		}
	}
	/**
	 * Calculates and returns the score of a completed quiz
	 * @return the number of correct answers 
	 * @throws RemoteException 
	 */
	@Test
	public void testCalculateScore() throws RemoteException{
		//set up testQ4 with correct answers & player answers
		Quiz q4 = new QuizImpl(121);
		q4.setQuizName("testQ4");
		Question mockQ1 = Mockito.mock(Question.class);
		Question mockQ2 = Mockito.mock(Question.class);
		Question mockQ3 = Mockito.mock(Question.class);
		Question mockQ4 = Mockito.mock(Question.class);
		Question mockQ5 = Mockito.mock(Question.class);
		q4.addQuestion(mockQ1);
		q4.addQuestion(mockQ2);
		q4.addQuestion(mockQ3);
		q4.addQuestion(mockQ4);
		q4.addQuestion(mockQ5);
		// define return value for method getCorrectAnswer()
		Mockito.when(mockQ1.getCorrectAnswer()).thenReturn('a');
		Mockito.when(mockQ2.getCorrectAnswer()).thenReturn('b');
		Mockito.when(mockQ3.getCorrectAnswer()).thenReturn('c');
		Mockito.when(mockQ4.getCorrectAnswer()).thenReturn('d');
		Mockito.when(mockQ5.getCorrectAnswer()).thenReturn('a');
		//add player answers to testQ2
		q4.recordAnswer(1, 'c');
		q4.recordAnswer(2, 'b');
		q4.recordAnswer(3, 'c');
		q4.recordAnswer(4, 'c');
		q4.recordAnswer(1, 'a');
		server.addFullQuizToList(q4);
		Quiz completedQuiz = server.getQuiz("testQ4");
		intOutput = server.calculateScore(completedQuiz);
		intExpected = 3;
		assertEquals(intExpected,intOutput);
		Mockito.verify(mockQ1).getCorrectAnswer();
	}
	/**
	 * Returns a list of the available quiz names
	 * @return quizList a list  of the available quiz names
	 */
	@Test
	public void testGetAvaliableQuizList() {
		
	}
}







































