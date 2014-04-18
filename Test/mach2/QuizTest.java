import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class QuizTest {
	Quiz testQ;
	QuizQuestions mockedQQ;
	int questionNumber;
	char charOutput;
	char charExpected;
	int intOutput;
	int intExpected;
	String strOutput;
	String strExpected;

	@Before
	public void setUp() throws Exception {
		mockedQQ = mock(QuizQuestions.class);
		testQ = new QuizImpl(mockedQQ);
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
	 * tests getQuizQuestions() method
	 */
	@Test
	public void testGetQuizQuestions(){
		QuizQuestions qqOutput = null;
		qqOutput = testQ.getQuizQuestions();
		assertNotNull(qqOutput);
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
	public void testCalculatePlayerScore(){
		when(mockedQQ.getQuizName()).thenReturn("Sports Quiz");
		Question mockQ1 = mock(Question.class);
		Question mockQ2 = mock(Question.class);
		Question mockQ3 = mock(Question.class);
		Question mockQ4 = mock(Question.class);
		Question mockQ5 = mock(Question.class);
		mockedQQ.addQuestion(mockQ1);
		mockedQQ.addQuestion(mockQ2);
		mockedQQ.addQuestion(mockQ3);
		mockedQQ.addQuestion(mockQ4);
		mockedQQ.addQuestion(mockQ5);
		
		when(mockedQQ.getQuestion(0)).thenReturn(mockQ1);
		when(mockedQQ.getQuestion(1)).thenReturn(mockQ2);
		when(mockedQQ.getQuestion(2)).thenReturn(mockQ3);
		when(mockedQQ.getQuestion(3)).thenReturn(mockQ4);
		when(mockedQQ.getQuestion(4)).thenReturn(mockQ5);
		
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(5);
		when(mockedQQ.getQuestionList()).thenReturn(mockList);

		// define return value for method getCorrectAnswer()
		when(mockQ1.getCorrectAnswer()).thenReturn('a');
		when(mockQ2.getCorrectAnswer()).thenReturn('b');
		when(mockQ3.getCorrectAnswer()).thenReturn('c');
		when(mockQ4.getCorrectAnswer()).thenReturn('d');
		when(mockQ5.getCorrectAnswer()).thenReturn('a');
		//add player answers to testQ
		testQ.recordAnswer(1, 'c');
		testQ.recordAnswer(2, 'b');
		testQ.recordAnswer(3, 'c');
		testQ.recordAnswer(4, 'c');
		testQ.recordAnswer(5, 'a');
		intOutput = testQ.calculatePlayerScore();
		intExpected = 3;
		assertEquals(intExpected,intOutput);
		verify(mockQ1, times(2)).getCorrectAnswer();
	}
	
	/**
	 * tests addQuestion() & getQuestion() methods
	 */
/*	@Test
	public void testAddQuestion() {
		Question q = new QuestionImpl();
		testQ.addQuestion(q);
		Question outputQuestion = testQ.getQuestion(1);
		assertNotNull(outputQuestion);
	}
*/
	
/*	@Test
	public void testGetQuizId() {
		intOutput = testQ.getQuizId();
		intExpected = 707;
		assertEquals(intExpected,intOutput);
	}
*/	/**
	 * test setQuizName() & getQuizName() methods
	 */
/*	@Test
	public void testSetQuizName() {
		testQ.setQuizName("Lets get quizzical");
		strOutput = testQ.getQuizName();
		strExpected = "Lets get quizzical";
		assertEquals(strExpected,strOutput);
	}
*/	
	/**
	 * test setHighScore() & getHighScore() methods
	 */
/*	@Test
	public void testSetHighScore() {
		testQ.setHighScore(8);
		intOutput = testQ.getHighScore();
		intExpected = 8;
	}
*/
	/**
	 * test setCurrentWinner() & getCurrentWinner() methods
	 */
/*	@Test
	public void testSetCurrentWinner() {
		testQ.setCurrentWinner("Laura");
		strOutput = testQ.getCurrentWinner();
		assertEquals("Laura",strOutput);
	}
*/	
}
































