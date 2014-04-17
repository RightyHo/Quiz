package mach2;

import java.rmi.RemoteException;


public interface InputOutput {
	void setFileName(String fileName);
	/**
	 * Stores the high score of the quiz and the name of the current winner on disk
	 * Also stores the quiz questions and the results of the various user attempts
	 * @param quizStore
	 */
	void saveToDisk(QuizStore quizStore) throws RemoteException; 
	
	/**
	 * Reads the file from disk and returns the objects stored there
	 * @return object array containing a results list and questions list
	 */
	Object[] readFromDisk();
	
	/**
	 * Checks whether the file already exists
	 * @return boolean value yes if the file already exists and no otherwise
	 */
	boolean fileAlreadyExists();
}
