package mach2;

import static org.junit.Assert.*;

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
		q2 = new QuestionImpl("Whats your favourite food?","Silverbeet","Shrimp","Mushroom","Lamb",'d');
		strOutput = "";
		strExpected = "";
		intOutput = 0;
		intExpected = 0;
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

	/**
	 * Checks whether the question is set up correctly
	 */
	@Test
	public void testIsQuestionValid(){
		Question questionOutput = new QuestionImpl("Whats your favourite sport?","Football","Rugby","Cricket","Squash",'B');
		assertTrue(questionOutput.isQuestionValid());
		questionOutput = new QuestionImpl(null,"Football","Rugby","Cricket","Squash",'B');
		assertFalse(questionOutput.isQuestionValid());
		questionOutput = new QuestionImpl("Whats your favourite sport?",null,"Rugby","Cricket","Squash",'B');
		assertFalse(questionOutput.isQuestionValid());
		questionOutput = new QuestionImpl("Whats your favourite sport?","Football",null,"Cricket","Squash",'B');
		assertFalse(questionOutput.isQuestionValid());
		questionOutput = new QuestionImpl("Whats your favourite sport?","Football","Rugby",null,"Squash",'B');
		assertFalse(questionOutput.isQuestionValid());
		questionOutput = new QuestionImpl("Whats your favourite sport?","Football","Rugby","Cricket",null,'B');
		assertFalse(questionOutput.isQuestionValid());
	}
}



















