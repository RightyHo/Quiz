import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class QuizGameServerImpl extends UnicastRemoteObject implements QuizGameServer {
	public QuizGameServerImpl() throws RemoteException {
		// nothing to initialise for this server
	}
	@Override
	public String echo(String s){
		System.out.println("Replied to a client saying '" + s + "'");
		return s;
	}
}
