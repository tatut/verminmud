/* Driver.java
 * 6.3.2003 Tatu Tarvainen
 *
 * Main class for all mud data.
 * Contains references to services.
 */
package org.vermin.driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import org.vermin.io.ClientConnection;

public class Driver {
	
	private static final Driver _instance = new Driver();
	
	private LinkedList<Service> connectionListeners = new LinkedList<Service>();
	private TickService tickService;
	private Loader loader;
	private AuthenticationProvider authenticator;
	private HashMap<String, Service> services = new HashMap<String, Service>();
	private ArrayList<String> typoMessage = new ArrayList<String>();
	private ClassMapping classMapping;
    
	private HashMap<String, Factory> objectFactories = new HashMap<String, Factory>();
	private HashMap<String, Factory> loginActionFactories = new HashMap<String, Factory>();

	// private JS scheme = new JS();

	public static Driver getInstance() {
		return _instance;
	}

	/**
	 * Returns the class mapping used with this loader.
	 *
	 * @return the class mapping
	 */
	public ClassMapping getClassMapping() {
		return classMapping;
	}

	public void setClassMapping(ClassMapping cm) {
		classMapping = cm;
	}

	public static URL getResource(String name) {
		URL resource = Driver.class.getClassLoader().getResource(name);
		if(resource == null)
			System.out.println("Unable to find resource: "+name);
		return resource;
	}

	public void run() throws Exception {
		// Start all services.
		for(Service s : connectionListeners)
			s.startService();
	}

	private Random typo = new Random();
	public String getTypoMessage() {
        if(typoMessage.size() == 0)
            return "What?";
        else
            return typoMessage.get(typo.nextInt(typoMessage.size()));
	}

	public void addTypoMessage(String msg) {
		typoMessage.add(msg);
	}

	public Object getLoginAction(String name) {
		Factory f = loginActionFactories.get(name);
		//System.out.println("GOT login action factory: "+f);
		if(f == null)
			return null;
		else 
			return f.create();
	}

	public void addLoginActionFactory(String name, Factory f) {
		System.out.println("ADDED login action factory");
		loginActionFactories.put(name, f);
	}

	public Loader getLoader() {
		return loader;
	}

	public TickService getTickService() {
		return tickService;
	}

	public AuthenticationProvider getAuthenticator() {
		return authenticator;
	}

	public Iterator<Service> connectionListeners() {
		return connectionListeners.iterator();
	}

	public void setLoader(Loader l) {
		loader = l;
	}

	public void setAuthenticator(AuthenticationProvider a) {
		authenticator = a;
	}

	public void setTickService(TickService ts) {
		tickService = ts;
	}
		
	public void addConnectionListener(Service cl) {
		connectionListeners.add(cl);
	}

	public Service getService(String name, boolean forceStart) {
		Service s = services.get(name);
		if(s != null && forceStart && !s.isActive())
			s.startService();
		return s;
	}
	
	public void addService(Service service) {
		services.put(service.getName(), service);
	}

	public void shutdown() {

		//

	}

	public void closeAllConnections() {
		

	}
    
    public void addFactory(String name, Factory f) {
        objectFactories.put(name, f);
    }
    public Factory getFactory(String name) {
        return objectFactories.get(name);
    }
    
    public void showRandomLogo(ClientConnection cc) { 
    	try {
    		BufferedReader in = new BufferedReader(new FileReader("misc/verminlogin1"));
    		String line = in.readLine();
    		while(line != null) {
    			cc.println(line);
    			line = in.readLine();
    		}
    		cc.flush();
    		in.close();
    	} catch(IOException ioe) {
    		// printing the logo is not that critical
    	}
    }
    
    	

}
