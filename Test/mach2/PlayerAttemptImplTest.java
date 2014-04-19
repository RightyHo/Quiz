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

public class PlayerAttemptImplTest {
	
	private String playerName = "Laura";
	private int playerScore = 0;
	private PlayerAttempt testPA;
	
	@Mock
	private Quiz mockQuiz;
	
	@Mock
	private List<Character> mockPlayerAnswers;
	
	@Mock
	private Question mockQuestion;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		testPA = new PlayerAttemptImpl(mockQuiz,playerName);
		when(mockQuiz.isQuizValid()).thenReturn(true);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * checks that the quiz question corresponding to the question number passed as parameter is returned by method getQuestion correctly
	 */
	@Test
	public void testGetQuestion(){
		when(mockQuiz.getQuestion(anyInt())).thenReturn(mockQuestion);
		Question outputQ = testPA.getQuestion(3);
		verify(mockQuiz).getQuestion(anyInt());
		assertEquals(mockQuestion,outputQ);
		
	}
	
	/**
	 * checks that addMarkToScore() method increments the player score by one & that getPlayerScore() returns the correct value  
	 */
	@Test
	public void testAddMarkToScore(){
		int expectedScore = playerScore + 1;
		testPA.addMarkToScore();
		int outputScore = testPA.getPlayerScore();
		assertEquals(expectedScore,outputScore);
	}
	
	/**
	 * checks that the saveResult() method in the Quiz class is called when the saveResult method is called from the PlayerAttempt class
	 */
	@Test
	public void testSaveResult(){
		testPA.saveResult();
		verify(mockQuiz).saveResult(anyInt(), anyString());
	}
	
	/**
	 * checks that the getQuiz method returns the correct quiz 
	 */
	@Test
	public void testGetQuiz(){
		Quiz quizOutput = testPA.getQuiz();
		assertEquals(mockQuiz,quizOutput);
	}
	
	/**
	 * checks that getPlayerName() returns the correct name of the player attempting the quiz
	 */
	@Test
	public void testGetPlayerName(){
		String outputName = testPA.getPlayerName();
		assertEquals(playerName,outputName);
	}
}































