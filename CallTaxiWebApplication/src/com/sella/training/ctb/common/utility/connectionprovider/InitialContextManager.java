package com.sella.training.ctb.common.utility.connectionprovider;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public final class InitialContextManager {

	/**
	 * The InitialContextManager
	 */
	private static InitialContextManager _instance;

	/**
	 * The InitialContext
	 */
	private static InitialContext initialContext;

	/**
	 * Instantiates a new InitialContextManager
	 */
	private InitialContextManager() {
	}

	/**
	 * Gets the InitialContextInstance
	 * 
	 * @return InitialContext
	 * @throws NamingException
	 */

	public InitialContext getInitialContextInstance()
			throws NamingException {

		if (initialContext == null) {
			Hashtable<String, String> environment = new Hashtable<String, String>();
			environment.put(Context.INITIAL_CONTEXT_FACTORY,
					"weblogic.jndi.WLInitialContextFactory");
			environment.put(Context.PROVIDER_URL, "t3://192.50.51.45:7001");
			initialContext = new InitialContext(environment);
		}
		return initialContext;
	}

	/**
	 * This is used to Get the single instance of InitialContextManager
	 * 
	 * @return single instance of InitialContextManager
	 */

	public static InitialContextManager getInstance() {
		if (_instance == null) {
			_instance = new InitialContextManager();
		}
		return _instance;
	}

}
