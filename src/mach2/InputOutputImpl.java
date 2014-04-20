package mach2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;


public class InputOutputImpl implements InputOutput,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4305952265804111068L;
	private String fileName;
	
	public InputOutputImpl(String fileName){
		this.fileName = fileName;
	}
	
	/**
	 * File name setter
	 * @param fileName
	 */
	public void setFileName(String fileName){
		this.fileName = fileName;
	}

	/**
	 * Stores the list of quizzes to file including the results of the various user attempts
	 * @param quizStore
	 */
	public void saveToDisk(QuizStore quizStore) throws RemoteException{
		File file = new File(fileName); 
		ObjectOutputStream out = null;
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(file);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(quizStore);
			System.out.printf("Serialized data is saved in " + fileName);
		} catch(FileNotFoundException ex) {
			System.out.println("Cannot write to file " + file + ".");
		} catch(IOException ex) { 
			ex.printStackTrace();
		} finally {
			closeWriter(out,fileOut);
		}
	}
	private void closeWriter(ObjectOutputStream out,FileOutputStream fileOut) { 
		try {
			if(out != null) { 
				out.close();
			}
			if(fileOut != null) { 
				fileOut.close();
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Reads the file from disk and returns the objects stored there
	 * @return object array containing a quiz store object
	 */
	@SuppressWarnings("finally")
	public Object[] readFromDisk(){
		QuizStore quizStore = null;
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		try {
            fileIn = new FileInputStream(fileName);
            in = new ObjectInputStream(fileIn);
            quizStore = (QuizStore) in.readObject();
        } catch(FileNotFoundException ex) {
			System.out.println("Cannot read from file " + fileName + ".");
		} catch(IOException ex) { 
			ex.printStackTrace();
		} finally {
			closeReader(in,fileIn);
			return new Object[]{quizStore};
		}
    }
	private void closeReader(ObjectInputStream in,FileInputStream fileIn) { 
		try {
			if(in != null) { 
				in.close();
			}
			if(fileIn != null) { 
				fileIn.close();
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Checks whether the file already exists
	 * @return boolean value true if the file already exists and false otherwise
	 */
	public boolean fileAlreadyExists(){
		return new File(fileName).exists();
	}
}

	





























