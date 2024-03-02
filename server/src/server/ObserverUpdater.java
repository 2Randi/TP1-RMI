package server;

import java.util.ArrayList;

import common.IObserver;

public class ObserverUpdater {
	
	//Attribut tableau
	private static final ArrayList<IObserver> observerList = new ArrayList<>();
	
	//
	public static synchronized void addIObserver(IObserver observer) {
		observerList.add(observer);
	}
	
	//Alerte dans serveur 
	public static synchronized void numberChanged(Object o) {
			for (IObserver observer : observerList) {
				try {
					observer.update(o);
				} catch (Exception e) {
	                System.err.println("observer disconnected, unsubscribing... "
	                		+ "Veulliez ressayer les simulations dans Console de Client.");
	                observerList.remove(observer);
	            }
			}
	}

}
