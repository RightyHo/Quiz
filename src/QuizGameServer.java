
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface QuizGameServer extends Remote {
	/**
	 * Returns the same string passed as parameter etc
	 */
	public String echo(String s) throws RemoteException;
	/**
	 * 
	 */
}
