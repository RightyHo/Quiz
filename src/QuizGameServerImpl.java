import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class QuizGameServerImpl extends UnicastRemoteObject implements QuizGameServer {
	private Map<Integer,Integer> quizMap;
	
	public QuizGameServerImpl() throws RemoteException {
		quizMap = new HashMap<Integer,Integer>();
	}
	@Override
	public String echo(String s){
		System.out.println("Replied to a client saying '" + s + "'");
		return s;
	}
	
}
