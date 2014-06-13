package com.sella.training.ctb.core.manager.cancellationManager;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sella.training.ctb.common.utility.connectionprovider.InitialContextManager;
import com.sella.training.ctb.persistence.sessionbeans.cancellationbean.interfaces.ICancellationBean;

public class CancellationManagerProvider {

	public static CancellationManager getCancellationManager()
			throws NamingException {
		CancellationManager cancellationManager = new CancellationManager();
		InitialContext initialContext = InitialContextManager.getInstance()
				.getInitialContextInstance();
		cancellationManager
				.setiCancellationBean((ICancellationBean) initialContext
						.lookup("ICancellationBeanDetails"));
		return cancellationManager;
	}

}
