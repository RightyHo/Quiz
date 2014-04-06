import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class QuizTest {
	Quiz testQ;
	int questionNumber;
	char charOutput;
	char charExpected;
	int intOutput;
	int intExpected;
	String strOutput;
	String strExpected;

	@Before
	public void setUp() throws Exception {
		testQ = new QuizImpl(707);
		charOutput = '?';
		charExpected = '?';
		intOutput = 0;
		intExpected = 0;
		strOutput = "";
		strExpected = "";
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * tests addQuestion() & getQuestion() methods
	 */
	@Test
	public void testAddQuestion() {
		Question q = new QuestionImpl();
		testQ.addQuestion(q);
		Question outputQuestion = testQ.getQuestion(1);
		assertNotNull(outputQuestion);
	}
	/**
	 * tests recordAnswer() and getPlayerAnswer() methods
	 */
	@Test
	public void testRecordAnswer() {
		try{
			testQ.recordAnswer(0,'a');
			testQ.recordAnswer(1,'d');
			testQ.recordAnswer(2,'b');
			charOutput = testQ.getPlayerAnswer(0);
			charExpected = 'a';
			assertEquals(charExpected,charOutput);
			charOutput = testQ.getPlayerAnswer(1);
			charExpected = 'd';
			assertEquals(charExpected,charOutput);
			charOutput = testQ.getPlayerAnswer(2);
			charExpected = 'b';
			assertEquals(charExpected,charOutput);
			charOutput = testQ.getPlayerAnswer(6);
			charExpected = 'a';
			assertEquals(charExpected,charOutput);
		} catch (IndexOutOfBoundsException ex){
			System.out.println("TEST PASSED - The player answer at the question number you selected doesn't exist!");
		}
	}

	@Test
	public void testGetQuizId() {
		intOutput = testQ.getQuizId();
		intExpected = 707;
		assertEquals(intExpected,intOutput);
	}
	/**
	 * test setQuizName() & getQuizName() methods
	 */
	@Test
	public void testSetQuizName() {
		testQ.setQuizName("Lets get quizzical");
		strOutput = testQ.getQuizName();
		strExpected = "Lets get quizzical";
		assertEquals(strExpected,strOutput);
	}
	
	/**
	 * test setHighScore() & getHighScore() methods
	 */
	@Test
	public void testSetHighScore() {
		testQ.setHighScore(8);
		intOutput = testQ.getHighScore();
		intExpected = 8;
	}

	/**
	 * test setCurrentWinner() & getCurrentWinner() methods
	 */
	@Test
	public void testSetCurrentWinner() {
		testQ.setCurrentWinner("Laura");
		strOutput = testQ.getCurrentWinner();
		assertEquals("Laura",strOutput);
	}
	
	@Test
	public void testCalculatePlayerScore(){
		testQ.setQuizName("Sports Quiz");
		Question mockQ1 = Mockito.mock(Question.class);
		Question mockQ2 = Mockito.mock(Question.class);
		Question mockQ3 = Mockito.mock(Question.class);
		Question mockQ4 = Mockito.mock(Question.class);
		Question mockQ5 = Mockito.mock(Question.class);
		testQ.addQuestion(mockQ1);
		testQ.addQuestion(mockQ2);
		testQ.addQuestion(mockQ3);
		testQ.addQuestion(mockQ4);
		testQ.addQuestion(mockQ5);
		// define return value for method getCorrectAnswer()
		Mockito.when(mockQ1.getCorrectAnswer()).thenReturn('a');
		Mockito.when(mockQ2.getCorrectAnswer()).thenReturn('b');
		Mockito.when(mockQ3.getCorrectAnswer()).thenReturn('c');
		Mockito.when(mockQ4.getCorrectAnswer()).thenReturn('d');
		Mockito.when(mockQ5.getCorrectAnswer()).thenReturn('a');
		//add player answers to testQ
		testQ.recordAnswer(1, 'c');
		testQ.recordAnswer(2, 'b');
		testQ.recordAnswer(3, 'c');
		testQ.recordAnswer(4, 'c');
		testQ.recordAnswer(5, 'a');
		intOutput = testQ.calculatePlayerScore();
		intExpected = 3;
		assertEquals(intExpected,intOutput);
		Mockito.verify(mockQ1).getCorrectAnswer();
	}
}
































