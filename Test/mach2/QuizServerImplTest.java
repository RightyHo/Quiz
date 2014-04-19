package mach2;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.rules.ExpectedException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class QuizServerImplTest {
	
	private QuizServer testServer;
	private String quizName = "Master Mind";
	
	@Mock
	private QuizStore mockQuizStore;
	
	@Mock
	private InputOutput mockIO;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
	initMocks(this);
	when(mockIO.fileAlreadyExists()).thenReturn(false);
	testServer = new QuizServerImpl(mockIO);
	
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Saves the quizStore to disk
	 * @throws RemoteException
	 */
	@Test
	public void testFlush() throws RemoteException{
		testServer.flush();
		verify(mockIO).saveToDisk(mockQuizStore);
	}
	
	/**
	 * Creates a new quiz
	 * @param quizName
	 * @return Quiz
	 */
	@Test
	public void testCreateNewQuiz(){
		testServer.createNewQuiz(quizName);
		verify(mockQuizStore).createNewQuiz(anyString());
	}
	
	/**
	 * Creates a new question object, sets the quiz question, four possible answer fields and indicates which one of them is the correct answer
	 * @param inputQ question string
	 * @param answerA possible answer string
	 * @param answerB possible answer string	
	 * @param answerC possible answer string	
	 * @param answerD possible answer string	
	 * @param correctAnswer char indicating which answer is correct	 
	 * @return Question
	 */
	@Test
	public void testCreateNewQuestion(){
		testServer.createNewQuestion("Is there life after death?", "No", "yes", "re-incarnation", "in a way yes...you become part of the plants/animals that feed on your bodies minerals", 'd');
		verify(mockQuizStore).createNewQuestion(anyString(), anyString(),anyString(),anyString(),anyString(), 'd');
	}
	
	/**
	 * Returns the quiz corresponding to a particular quiz ID
	 * @param quizId
	 * @return Quiz 
	 */
	@Test
	public void testGetQuiz(){
	}
	
	/**
	 * Returns a new player quiz attempt object based on the quiz that corresponds to the quiz name passed to the method
	 * @param quizName
	 * @param playerName
	 * @return PlayerAttempt 
	 */
	@Test
	public void testgetQuizAttempt(){
	}
	
	/**
	 * Returns a list of the available quizzes a user can play
	 * @return List of string values representing the available quizzes a user can play
	 */
	@Test
	public void testGetAvaliableQuizList(){
	}
	
	/**
	 * Adds a mark to the players score 
	 * @param game a player attempt based on a certain quiz
	 */
	@Test
	public void testAddMarkToScore(){

	}
	
	/**
	 * Returns the player score for a particular player attempt of a quiz
	 * @param game a player attempt based on a certain quiz
	 * @return int value of the player score
	 */
	@Test
	public void testGetPlayerScore(){
	}
	
	/**
	 * Adds a new quiz to the quiz list and saves it to disk
	 * @param newQuiz
	 * @throws RemoteException
	 */
	@Test
	public void testSaveQuiz(){
		
	}
	
	/**
	 * Adds the result of a player attempt to the results list and saves it to disk
	 * @param game a player attempt
	 * @throws RemoteException
	 */
	@Test
	public void testSaveResult(){
		
	}
	
	/**
	 * Closes the quiz game referenced by a particular quiz ID and saves the quiz store to disk
	 * @param quizId
	 * @throws RemoteException
	 */
	@Test
	public void testCloseQuizGame(){
		
	}
}

































