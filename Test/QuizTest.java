import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


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
		
	}

}
































