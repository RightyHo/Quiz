import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.List;


public class InputOutputImpl implements InputOutput {
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
	 * Stores the high score of the quiz and the name of the current winner on disk
	 * Also stores the quiz questions and the results of the various user attempts
	 * @param resultsList
	 * @param questionsList
	 */
	public void saveToDisk(List<QuizResults> resultsList,List<QuizQuestions> questionsList) throws RemoteException{
		File file = new File(fileName); 
		ObjectOutputStream out = null;
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(file);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(resultsList);
			out.writeObject(questionsList);
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
	 * @return object array containing a results list and questions list
	 */
	public Object[] readFromDisk(){
		List<QuizResults> resultsList = null;
		List<QuizQuestions> questionsList = null;
		FileInputStream fileIn = null;
		ObjectInputStream in = null;
		try {
            fileIn = new FileInputStream(fileName);
            in = new ObjectInputStream(fileIn);
            resultsList = (List<QuizResults>) in.readObject();
            questionsList = (List<QuizQuestions>) in.readObject();
        } catch(FileNotFoundException ex) {
			System.out.println("Cannot read from file " + fileName + ".");
		} catch(IOException ex) { 
			ex.printStackTrace();
		} finally {
			closeReader(in,fileIn);
			return new Object[]{resultsList, questionsList};
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
	 * @return boolean value yes if the file already exists and no otherwise
	 */
	public boolean fileAlreadyExists(){
		return new File(fileName).exists();
	}
}

	





























