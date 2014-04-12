import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class QuizGameServerTest {
	QuizGameServer server;
	Quiz quizOutput;
	String strOutput;
	String strExpected;
	int intOutput;
	int intExpected;
	Quiz mockQ1;
	Quiz mockQ2;
	Quiz mockQ3;
	QuizQuestions mockQQ;
	Question mQuestion1;
	Question mQuestion2;
	Question mQuestion3;
	QuizResults mockResults;

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
		mockQ1 = mock(Quiz.class);
		mockQ2 = mock(Quiz.class);
		mockQ3 = mock(Quiz.class);

		mockQQ = mock(QuizQuestions.class);

		when(mockQ1.getQuizQuestions()).thenReturn(mockQQ);
		when(mockQ2.getQuizQuestions()).thenReturn(mockQQ);
		when(mockQ3.getQuizQuestions()).thenReturn(mockQQ);

		when(mockQQ.getQuizName()).thenReturn("Geography");

		mQuestion1 = mock(Question.class);
		mQuestion2 = mock(Question.class);
		mQuestion3 = mock(Question.class);

		mockQQ.addQuestion(mQuestion1);
		mockQQ.addQuestion(mQuestion2);
		mockQQ.addQuestion(mQuestion3);

		// define return value for method getQuestion()
		when(mQuestion1.getQuestion()).thenReturn("whats the largest country in the world?");
		when(mQuestion2.getQuestion()).thenReturn("whats the capital of New Zealand?");
		when(mQuestion3.getQuestion()).thenReturn("What country borders USA to the south?");

		mockResults = mock(QuizResults.class);

		when(mockResults.getHighScore()).thenReturn(8);
		when(mockResults.getCurrentWinner()).thenReturn("Jamie");

		server.addFullQuizToList(mockQ1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPopulateQuestion() throws RemoteException{
		
		strExpected = "What is the capital city of Nicaragua?";
		strOutput = server.populateQuestion("Geography", "What is the capital city of Nicaragua?", "Tegucigalpa", "Belize City", "Managua", "San Jose", 'c');
		assertEquals(strExpected,strOutput);
		quizOutput = server.getQuiz("Geography");
	}
	/**
	 * Tests addFullQuizToList() and getQuiz() methods
	 */

	/**
	 * Adds a full quiz to the quizList and also adds a corresponding QuizResults object to the resultsList
	 * @param fullQuiz a quiz that has been set up with all of its questions and suggested answers
	 * @return QuizResults creates and returns a new QuizResults object to store the quiz results
	 */
	@Test
	public void testAddFullQuizToList() throws RemoteException{
		QuizQuestions Q4mockQuestions = mock(QuizQuestions.class);
		Quiz q4 = new QuizImpl(Q4mockQuestions);

		when(Q4mockQuestions.getQuizName()).thenReturn("Famous People");

		Question questMock1 = mock(Question.class);
		Question questMock2  = mock(Question.class);
		Question questMock3  = mock(Question.class);

		Q4mockQuestions.addQuestion(questMock1);
		Q4mockQuestions.addQuestion(questMock2);
		Q4mockQuestions.addQuestion(questMock3);

		// define return value for method getQuestion()
		when(mQuestion1.getQuestion()).thenReturn("who was the 35th US President");
		when(mQuestion2.getQuestion()).thenReturn("Who is the current prime minister of the UK?");
		when(mQuestion3.getQuestion()).thenReturn("Who has the 100m world mens running record?");

		QuizResults qrOutput = server.addFullQuizToList(q4);
	
		quizOutput = server.getQuiz("Famous People");
		assertEquals(q4,quizOutput);
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
		Mockito.when(mockQ1.getCorrectAnswer()).thenReturn('c');
		Mockito.when(mockQ2.getCorrectAnswer()).thenReturn('b');
		Mockito.when(mockQ3.getCorrectAnswer()).thenReturn('c');
		Mockito.when(mockQ4.getCorrectAnswer()).thenReturn('d');
		Mockito.when(mockQ5.getCorrectAnswer()).thenReturn('a');
		//add player answers to testQ2
		q4.recordAnswer(1, 'c');
		q4.recordAnswer(2, 'b');
		q4.recordAnswer(3, 'c');
		q4.recordAnswer(4, 'c');
		q4.recordAnswer(4, 'a');
		server.addFullQuizToList(q4);
		Quiz completedQuiz = server.getQuiz("testQ4");
		intOutput = server.calculateScore(completedQuiz);
		intExpected = 4;
		assertEquals(intExpected,intOutput);
		Mockito.verify(mockQ1).getCorrectAnswer();
	}

	@Test
	public void testGetAvaliableQuizList() throws RemoteException {
		List<String> listExpected = new ArrayList<String>();
		listExpected.add("testQ1");
		listExpected.add("testQ2");
		listExpected.add("testQ3");
		List<String> listOutput = server.getAvaliableQuizList();
		assertEquals(listExpected,listOutput);
	}

	/*@Test
	public void testGetQuiz() throws RemoteException{
		QuizQuestions mockingQQ = mock(QuizQuestions.class);
		Quiz q5 = new QuizImpl(mockingQQ);
		mockingQQ.setQuizName("testQ5");
		Question test1 = mock(Question.class);
		Question test2 = mock(Question.class);
		Question test3 = mock(Question.class);
		mockingQQ.addQuestion(test1);
		mockingQQ.addQuestion(test2);
		mockingQQ.addQuestion(test3);
		// define return value for method getQuestion()
		when(test1.getQuestion()).thenReturn("Test 1 question?");
		when(test2.getQuestion()).thenReturn("Test 2 question?");
		when(test3.getQuestion()).thenReturn("Test 3 question?");

		Quiz quizExpected = q5;

		server.addFullQuizToList(q5);
		Quiz quizOutput = server.getQuiz("testQ5");
		assertEquals(quizExpected,quizOutput);
	}
*/
	@Test
	public void testFlush() throws RemoteException{
		server.flush();
	}
}







































