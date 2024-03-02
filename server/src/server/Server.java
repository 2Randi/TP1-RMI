package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String CODEBASE_PATH = "file:/C:/Users/SCD%20UM/eclipse-workspace/server/bin/policies/server.policy";
		System.out.println("codebase path is : "+CODEBASE_PATH+"\n");
		
		System.setProperty("java.security.policy", "policies/server.policy");
		
		//Creation gestionnaire de securite
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}


		try {
			Cabinet objCabinet = new Cabinet();
			Observable objObservable = new Observable();
			Registry registry = LocateRegistry.createRegistry(1099);
			if (registry == null) {
				System.err.println("RMIRegistry not found !");
			} else {
				registry.bind("cabinet", objCabinet);
				registry.bind("observable", objObservable);
				System.err.println("Server ready ...");
			}
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
