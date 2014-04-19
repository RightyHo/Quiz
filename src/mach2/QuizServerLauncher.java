package mach2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class QuizServerLauncher {
	
	private static final String fileName = "quizFile.ser";
	
	public static void main(String[] args){
		QuizServerLauncher qG = new QuizServerLauncher();
		qG.launch();
	}
	
	private void launch(){
		//if there is no security manager then start one
		if(System.getSecurityManager() == null){
			System.setSecurityManager(new RMISecurityManager());
		}
		try{
			//create the registry if there is not one
			LocateRegistry.createRegistry(1099);
			//create the server object
			InputOutput io = new InputOutputImpl(fileName);
			QuizServer server = new QuizServerImpl(io);
			//register (bind) the server object on the registry - the registry may be on a different machine
			String registryHost = "//localhost/";
			String serviceName = "quiz";
			Naming.rebind(registryHost + serviceName, (Remote) server);
		} catch (MalformedURLException ex){
			ex.printStackTrace();
		} catch (RemoteException ex){
			ex.printStackTrace();
		}
	}
}
