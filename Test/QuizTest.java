import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class QuizTest {
	Quiz testQ;
	int questionNumber;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testQ = new QuizImpl(707);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddQuestion() {
		Question q = new QuestionImpl(;)
		testQ.addQuestion(question);
	}

	@Test
	public void testGetQuestion() {
		Question outputQuestion = testQ.getQuestion(1);
		assertNull(outputQuestion);
	}

	@Test
	public void testRecordAnswer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetQuizId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetQuizName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetQuizName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetHighScore() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHighScore() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCurrentWinner() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentWinner() {
		fail("Not yet implemented");
	}

}
