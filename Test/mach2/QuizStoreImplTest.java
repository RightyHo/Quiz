package mach2;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		testQS = new QuizStoreImpl();
		when(mockInitialQuiz.isQuizValid()).thenReturn(true);
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
	 * check that getQuizAttempt() method throws an IllegalArgumentException when passed a null quiz name
	 */
	@Test
	public void testGetQuizAttemptWithNullQuizName(){
		thrown.expect(IllegalArgumentException.class);
		testQS.getQuizAttempt(null,"Ken");
	}

	/**
	 * check that getQuizAttempt() method throws an IllegalArgumentException when passed a null player name
	 */
	@Test
	public void testGetQuizAttemptWithNullPlayerName(){
		thrown.expect(IllegalArgumentException.class);
		testQS.getQuizAttempt(quizName,null);
	}
	
	/**
	 * ***Error - outputPA currently returning a null pointer***should i be testing by using a mockQuizList???
	 */
	@Test
	public void testGetQuizAttempt(){
		PlayerAttempt mockedPA = mock(PlayerAttempt.class);
		when(mockedPA.getPlayerName()).thenReturn("Nicky");
		when(mockQuiz.getQuizName()).thenReturn(quizName);
		PlayerAttempt outputPA = testQS.getQuizAttempt(quizName,"Nicky");
		assertEquals(mockedPA.getPlayerName(),outputPA.getPlayerName());
	}

	/**
	 * Returns the quiz corresponding to a particular quiz ID
	 * @param quizId
	 * @return Quiz 
	 */
	@Test
	public void testGetQuiz(){
		Quiz outputQuiz = testQS.getQuiz(1);
		
		
	}

	/**
	 * Returns a list of the available quizzes a user can play
	 * @return List of string values representing the available quizzes a user can play
	 */
	public List<String> getAvailableQuizList(){

	}

	/**
	 * Adds a mark to the players score 
	 * @param game a player attempt based on a certain quiz
	 * @throws IllegalArgumentException
	 */
	public void addMarkToScore(){

	}

	/**
	 * Returns the player score for a particular player attempt of a quiz
	 * @param game a player attempt based on a certain quiz
	 * @return int value of the player score
	 * @throws IllegalArgumentException
	 */
	public int getPlayerScore(){
	
	}

	/**
	 * Adds a new quiz to the quiz list and saves it to disk
	 * @param newQuiz
	 * @throws IllegalArgumentException
	 */
	public void saveQuiz(){

	}

	/**
	 * Adds the result of a player attempt to the results list and saves it to disk
	 * @param game a player attempt
	 * @throws IllegalArgumentException
	 */
	public void saveResult(){

	}
	
	/**
	 * Closes the quiz game referenced by a particular quiz ID and saves the quiz store to disk
	 * @param quizId
	 */
	public void closeQuizGame(){
		
	}

}
