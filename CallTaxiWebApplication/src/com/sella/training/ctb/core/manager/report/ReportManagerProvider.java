package com.sella.training.ctb.core.manager.report;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sella.training.ctb.common.utility.connectionprovider.InitialContextManager;
import com.sella.training.ctb.persistence.sessionbeans.reportbean.interfaces.IReportBean;

public class ReportManagerProvider {

	public static IReportManager getReportManager() throws NamingException {
		ReportManager reportManager = new ReportManager();
		InitialContext initialContext = InitialContextManager.getInstance()
				.getInitialContextInstance();
		reportManager.setiReportBean((IReportBean) initialContext
				.lookup("IReportBeanDetails"));
		return reportManager;
	}
}