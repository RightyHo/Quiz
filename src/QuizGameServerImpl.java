import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class QuizGameServerImpl extends UnicastRemoteObject implements QuizGameServer {
	private List<Quiz> quizList;
	
	public QuizGameServerImpl() throws RemoteException {
		quizList = new ArrayList<Quiz>();
	}
	@Override
	public String echo(String s){
		System.out.println("Replied to a client saying '" + s + "'");
		return s;
	}
	
}
