import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class QuestionTest {
	Question q1;
	Question q2;
	String strOutput;
	String strExpected;
	int intOutput;
	int intExpected;

	@Before
	public void setUp() throws Exception {
		q1 = new QuestionImpl();
		q2 = new QuestionImpl(845,"Whats your favourite food?","Silverbeet","Shrimp","Mushroom","Lamb",'d');
		strOutput = "";
		strExpected = "";
		intOutput = 0;
		intExpected = 0;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetQuestionId() {
		q1.setQuestionId(343);
		intOutput = q1.getQuestionId();
		intExpected = 343;
		assertEquals(intExpected,intOutput);
	}

	@Test
	public void testGetQuestionId() {
		intOutput = q2.getQuestionId();
		intExpected = 845;
		assertEquals(intExpected,intOutput);
	}

	@Test
	public void testSetQuestion() {
		q1.setQuestion("Will New Zealand win the 2014 T20 world cup?");
		strOutput = q1.getQuestion();
		strExpected = "Will New Zealand win the 2014 T20 world cup?";
		assertEquals(strExpected,strOutput);
	}

	@Test
	public void testGetQuestion() {
		strOutput = q2.getQuestion();
		strExpected = "Whats your favourite food?";
		assertEquals(strExpected,strOutput);
	}
	/**
	 * tests setAnswers() method and also tests getAnswer() and getCorrectAnswer() methods
	 */
	@Test
	public void testSetAnswers() {
		q1.setAnswers("They boycotted the cup because as an anti-Whaling protest", "Yes,easily!","No, they've already been knocked out","No, they were robbed by the umpires and weren't given the chance!", 'c');
		strOutput = q1.getAnswer('A');
		strExpected = "They boycotted the cup because as an anti-Whaling protest";
		assertEquals(strExpected,strOutput);
		char charOutput = q1.getCorrectAnswer();
		char charExpected = 'c';
		assertEquals(charExpected,charOutput);
		charOutput = q2.getCorrectAnswer();
		charExpected = 'd';
		assertEquals(charExpected,charOutput);
	}

}



















