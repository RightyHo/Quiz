package mach2;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class InputOutputImplTest {

	private InputOutput io;
	
	@Before
	public void setUp() throws Exception {
		io = new InputOutputImpl("testQuizFile.ser");
	}

	/**
	 * checks that the saveToDisk() & readFromDisk() methods work correctly
	 * @throws RemoteException 
	 */
	@Test
	public void testSaveToDisk() throws RemoteException{
		QuizStore serializableMockQuizStore = mock(QuizStore.class,withSettings().serializable());
		io.saveToDisk(serializableMockQuizStore);
		Object[] obj = io.readFromDisk();
		QuizStore outputQS = (QuizStore) obj[0];
		assertNotNull(outputQS);
	}



	/**
	 * checks fileAlreadyExists() method produces a valid return value
	 * ...returns false the first time the test is run and true for all successive tests
	 */
	@Test
	public void testFileAlreadyExists(){
		assertTrue(io.fileAlreadyExists());
	}
}
