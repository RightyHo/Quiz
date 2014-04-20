package mach2;

import java.rmi.RemoteException;

import org.junit.rules.ExpectedException;
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
	
	@Mock
	private PlayerAttempt mockPA;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
	initMocks(this);
	when(mockIO.fileAlreadyExists()).thenReturn(false);
	testServer = new QuizServerImpl(mockQuizStore,mockIO);
	}

	/**
	 * checks that flush() method invokes a saveToDisk() method call on the QuizStore class
	 */
	@Test
	public void testFlush() throws RemoteException{
		testServer.flush();
		verify(mockIO).saveToDisk(mockQuizStore);
	}
	
	/**
	 * checks that createNewQuiz() method invokes a createNewQuiz() method call on the QuizStore class
	 */
	@Test
	public void testCreateNewQuiz(){
		testServer.createNewQuiz(quizName);
		verify(mockQuizStore).createNewQuiz(anyString());
	}
	
	/**
	 * checks that createNewQuestion() method invokes a createNewQuestion() method call on the QuizStore class
	 */
	@Test
	public void testCreateNewQuestion(){
		testServer.createNewQuestion("Is there life after death?", "No", "yes", "re-incarnation", "in a way yes...you become part of the plants/animals that feed on the remains of your body", 'd');
		verify(mockQuizStore).createNewQuestion("Is there life after death?", "No", "yes", "re-incarnation", "in a way yes...you become part of the plants/animals that feed on the remains of your body",'d');
	}
	
	/**
	 * checks that getQuiz() method invokes a getQuiz() method call on the QuizStore class
	 */
	@Test
	public void testGetQuiz(){
		testServer.getQuiz(888);
		verify(mockQuizStore).getQuiz(anyInt());
	}
	
	/**
	 * checks that getQuizAttempt() method invokes a getQuizAttempt() method call on the QuizStore class
	 */
	@Test
	public void testgetQuizAttempt(){
		testServer.getQuizAttempt(quizName, "Philippa");
		verify(mockQuizStore).getQuizAttempt(anyString(), anyString());
	}
	
	/**
	 * checks that getAvailableQuizList() method invokes a getAvailableQuizList() method call on the QuizStore class
	 */
	@Test
	public void testGetAvailableQuizList(){
		testServer.getAvailableQuizList();
		verify(mockQuizStore).getAvailableQuizList();
	}
	
	/**
	 * checks that addMarkToScore() method invokes a addMarkToScore() method call on the QuizStore class
	 */
	@Test
	public void testAddMarkToScore(){
		testServer.addMarkToScore(mockPA);
		verify(mockQuizStore).addMarkToScore(mockPA);
	}
	
	/**
	 * checks that getPlayerScore() method invokes a getPlayerScore() method call on the QuizStore class
	 */
	@Test
	public void testGetPlayerScore(){
		testServer.getPlayerScore(mockPA);
		verify(mockQuizStore).getPlayerScore(mockPA);
	}
	
	/**
	 * checks that saveQuiz() method invokes a saveQuiz() method call on the QuizStore class
	 */
	@Test
	public void testSaveQuiz() throws RemoteException{
		Quiz mockedQuiz = mock(Quiz.class);
		testServer.saveQuiz(mockedQuiz);
		verify(mockQuizStore).saveQuiz(mockedQuiz);
	}
	
	/**
	 * checks that saveResult() method invokes a saveResult() method call on the QuizStore class
	 */
	@Test
	public void testSaveResult() throws RemoteException{
		testServer.saveResult(mockPA);
		verify(mockQuizStore).saveResult(mockPA);
	}
	
	/**
	 * checks that closeQuizGame() method invokes a closeQuizGame() method call on the QuizStore class
	 */
	@Test
	public void testCloseQuizGame(){
		try {
			testServer.closeQuizGame(567);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		verify(mockQuizStore).closeQuizGame(anyInt());
	}
}

































