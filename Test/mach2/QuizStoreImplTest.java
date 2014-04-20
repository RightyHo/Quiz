package mach2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class QuizStoreImplTest {
	
	private QuizStore testQS;
	private String quizName = "Cricket Players";
	
	@Mock
	private List<Quiz> mockQuizList;

	@Mock
	private Quiz mockInitialQuiz;
	
	@Mock
	private Quiz mockQuiz;
	
	@Mock
	private Question mockQuestion;
	
	@Mock
	private PlayerAttempt mockedPA;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		testQS = new QuizStoreImpl();
		when(mockInitialQuiz.isQuizValid()).thenReturn(true);
		when(mockInitialQuiz.getQuizId()).thenReturn(14);
		when(mockInitialQuiz.getQuizName()).thenReturn("What was the best movie of 2013?");
		testQS.saveQuiz(mockInitialQuiz);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * checks that trying to create a new quiz with a null quiz name throws IllegalArgumentException
	 */
	@Test
	public void testCreateNewQuizWithNullQuizName(){
		thrown.expect(IllegalArgumentException.class);
		testQS.createNewQuiz(null);
	}

	/**
	 * checks that createNewQuiz() method returns a non-null Quiz object
	 */
	@Test
	public void testCreateNewQuiz(){
		Quiz outputQuiz = testQS.createNewQuiz(quizName);
		assertNotNull(outputQuiz);
	}
	
	/**
	 * checks that createNewQuestion() method creates a new question object that is not null
	 */
	@Test
	public void testCreateNewQuestion(){
		Question outputQuestion = testQS.createNewQuestion("Who is the best batsmen that ever lived?", "Don Bradman", "Viv Richards", "Sachin Tendulkar", "Jacques Kallis", 'a');
		assertNotNull(outputQuestion);
	}

	/**
	 * checks that getQuizAttempt() method throws an IllegalArgumentException when passed a null quiz name
	 */
	@Test
	public void testGetQuizAttemptWithNullQuizName(){
		thrown.expect(IllegalArgumentException.class);
		testQS.getQuizAttempt(null,"Ken");
	}

	/**
	 * checks that getQuizAttempt() method throws an IllegalArgumentException when passed a null player name
	 */
	@Test
	public void testGetQuizAttemptWithNullPlayerName(){
		thrown.expect(IllegalArgumentException.class);
		testQS.getQuizAttempt(quizName,null);
	}
	
	/**
	 * ***Error - outputPA currently returning a null pointer****should i be testing by using a mockQuizList???****
	 */
	@Test
	public void testGetQuizAttempt(){
		PlayerAttempt outputPA = testQS.getQuizAttempt("What was the best movie of 2013?","Nicky");
		assertNotNull(outputPA);
	}

	/**
	 * checks that the getQuiz() method returns the quiz corresponding to a particular quiz ID or null if the quiz ID is not valid
	 */
	@Test
	public void testGetQuiz(){
		Quiz outputQuiz = testQS.getQuiz(14);
		assertNotNull(outputQuiz);
		Quiz outputNullQuiz = testQS.getQuiz(333);
		assertNull(outputNullQuiz);
	}

	/**
	 * checks that the getAvailableQuizList() method returns a correct list of the available quizzes
	 */
	@Test
	public void testGetAvailableQuizList(){
		List<String> outputList = testQS.getAvailableQuizList();
		for(String s : outputList){
		System.out.println(s);
		}
		assertTrue(outputList.size() == 1);
	}

	/**
	 * checks that addMarkToScore() method throws IllegalArgumentException when passed a null player attempt object
	 */
	@Test
	public void testAddMarkToScoreWithNullPlayerAttempt(){
		thrown.expect(IllegalArgumentException.class);
		testQS.addMarkToScore(null);
	}

	/**
	 * checks that addMarkToScore() method invokes a corresponding method call on the PlayerAttempt class which is its parameter
	 */
	@Test
	public void testAddMarkToScore(){
		testQS.addMarkToScore(mockedPA);
		verify(mockedPA).addMarkToScore();
	}
	
	/**
	 * check that getPlayerScore() method throws IllegalArgumentException when passed a null player attempt object
	 */
	@Test
	public void testGetPlayerScoreWithNullPlayerAttempt(){
		thrown.expect(IllegalArgumentException.class);
		testQS.getPlayerScore(null);
	}
	
	/**
	 * checks that getPlayerScore() method returns the correct value 
	 */
	@Test
	public void testGetPlayerScore(){
		when(mockedPA.getPlayerScore()).thenReturn(6);
		int outputScore = testQS.getPlayerScore(mockedPA);
		assertEquals(6,outputScore);
	}

	/**
	 * checks that saveQuiz() method throws IllegalArgumentException when passed a null Quiz
	 */
	@Test
	public void testSaveQuizWithNullQuiz(){
		thrown.expect(IllegalArgumentException.class);
		testQS.saveQuiz(null);
	}

	/**
	 * checks that saveQuiz() method adds a new quiz to the quiz list
	 */
	@Test
	public void testSaveQuiz(){
		Quiz mockedNewQuiz = mock(Quiz.class);
		when(mockedNewQuiz.isQuizValid()).thenReturn(true);
		when(mockedNewQuiz.getQuizId()).thenReturn(777);
		when(mockedNewQuiz.getQuizName()).thenReturn("I hope this works?");
		testQS.saveQuiz(mockedNewQuiz);
		Quiz outputQuiz = testQS.getQuiz(777);
		assertEquals("I hope this works?",outputQuiz.getQuizName());
	}
	
	/**
	 * checks that saveQuiz() method throws IllegalArgumentException when passed a null Quiz
	 */
	@Test
	public void testSaveResultWithNullPlayerAttemp(){
		thrown.expect(IllegalArgumentException.class);
		testQS.saveResult(null);
	}
	
	/**
	 * checks that saveResult() method invokes the saveResult() method on the PlayerAttempt object passed as its object
	 */
	@Test
	public void testSaveResult(){
		PlayerAttempt mockedAttempt = mock(PlayerAttempt.class);
		testQS.saveResult(mockedAttempt);
		verify(mockedAttempt).saveResult();
	}
	
	/**
	 * checks that closeQuizGame() method closes the quiz game referenced by a particular quiz ID 
	 */
	@Test
	public void testCloseQuizGame(){
		Quiz mockedQuizToClose = mock(Quiz.class);
		when(mockedQuizToClose.isQuizValid()).thenReturn(true);
		when(mockedQuizToClose.getQuizId()).thenReturn(312);
		when(mockedQuizToClose.getQuizName()).thenReturn("Short Lived Quiz");
		testQS.saveQuiz(mockedQuizToClose);
		List<String> howLongIsThisList = testQS.getAvailableQuizList();
		int listLength = howLongIsThisList.size();
		testQS.closeQuizGame(312);
		howLongIsThisList =  testQS.getAvailableQuizList();
		int outputLength = howLongIsThisList.size();
		assertTrue(outputLength < listLength);
	}

}






























