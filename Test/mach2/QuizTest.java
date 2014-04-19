package mach2;

import static org.junit.Assert.*;

import org.junit.rules.ExpectedException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;


public class QuizTest {
	
	private int quizId = 1;
	private String quizName = "New Zealand Place Names";
	private Quiz testQuiz;
	
	@Mock
	private Question mockInitialQuestion;
	@Mock
	private Question mockQuestion;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		testQuiz = new QuizImpl(quizId,quizName);
		when(mockInitialQuestion.isQuestionValid()).thenReturn(true);
		testQuiz.addQuestionToQuiz(mockInitialQuestion);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * checks that getQuizId returns correct value
	 */
	@Test
	public void testGetQuizId(){
	assertEquals(quizId,testQuiz.getQuizId());	
	}
	
	/**
	 * checks that get quiz name returns correct value
	 */
	@Test
	public void testGetQuizName(){
	assertEquals(quizName,testQuiz.getQuizName());	
	}
	
	/**
	 * checks that addQuestionToQuiz throws an IllegalArgumentException when question is not valid
	 */
	@Test
	public void testAddQuestionToQuizThrowsException(){
		thrown.expect(IllegalArgumentException.class);
		when(mockQuestion.isQuestionValid()).thenReturn(false);
		testQuiz.addQuestionToQuiz(mockQuestion);
	}

	/**
	 * checks that addQuestionToQuiz & getQuestion methods work correctly
	 */
	@Test
	public void testGetQuestion(){
		when(mockQuestion.isQuestionValid()).thenReturn(true);
		testQuiz.addQuestionToQuiz(mockQuestion);
		Question output = testQuiz.getQuestion(2);
		assertEquals(mockQuestion,output);
	}
	
	/**
	 * checks that getQuestion throws an IndexOutOfBoundsException when called with an out of bounds index number
	 */
	@Test
	public void testGetQuestionThrowsException(){
		thrown.expect(IndexOutOfBoundsException.class);
		testQuiz.getQuestion(3521);
	}
	
	/**
	 * checks that getCurrentWinner returns the correct value
	 */
	@Test
	public void testGetCurrentWinner(){
		assertEquals("",testQuiz.getCurrentWinner());
	}
	
	/**
	 * checks that getHighScore returns the correct value
	 */
	@Test
	public void testGetHighScore(){
		assertEquals(0,testQuiz.getHighScore());
	}
	
	/**
	 * checks that isQuizValid method returns the correct value
	 */
	@Test
	public void testIsQuizValid(){
		Quiz completeQuiz = new QuizImpl(44,"Complete Quiz");
		assertTrue(completeQuiz.isQuizValid());
		Quiz noIdQuiz = new QuizImpl(0,"No ID Quiz");
		assertFalse(noIdQuiz.isQuizValid());
		Quiz noNameQuiz = new QuizImpl(3,null);
		assertFalse(noNameQuiz.isQuizValid());
	}
	
	/**
	 * checks that saveResult method stores the correct values
	 */
	@Test
	public void testSaveResult(){
		testQuiz.saveResult(7,"Andrew");
		assertEquals(7,testQuiz.getHighScore());
	}
}
































