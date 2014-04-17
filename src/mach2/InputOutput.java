package mach2;

import java.rmi.RemoteException;


public interface InputOutput {
	/**
	 * File name setter
	 * @param fileName
	 */
	void setFileName(String fileName);
	
	/**
	 * Stores the list of quizzes to file including the results of the various user attempts
	 * @param quizStore
	 */
	void saveToDisk(QuizStore quizStore) throws RemoteException; 
	
	/**
	 * Reads the file from disk and returns the objects stored there
	 * @return object array containing a quiz store object
	 */
	Object[] readFromDisk();
	
	/**
	 * Checks whether the file already exists
	 * @return boolean value true if the file already exists and false otherwise
	 */
	boolean fileAlreadyExists();
}
