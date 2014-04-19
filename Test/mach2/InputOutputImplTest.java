package mach2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InputOutputImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	/**
	 * Stores the list of quizzes to file including the results of the various user attempts
	 * @param quizStore
	 */
	public void saveToDisk(QuizStore quizStore){
		
	}

	/**
	 * Reads the file from disk and returns the objects stored there
	 * @return object array containing a quiz store object
	 */
	public Object[] readFromDisk(){
		
	}

	/**
	 * Checks whether the file already exists
	 * @return boolean value true if the file already exists and false otherwise
	 */
	public boolean fileAlreadyExists(){
		
	}
}
