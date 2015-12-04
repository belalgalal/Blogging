package com.ithinkisink.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithinkisink.managedbean.DynamicReportsManagedBean;

/**
 * 
 * @author Belal
 *
 */
public class DynamicReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private DynamicReportsManagedBean dynamicReportsManagedBean;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/pdf");
		OutputStream out = resp.getOutputStream();
		out = dynamicReportsManagedBean.getOS(getServletContext(), out);
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
		this.doGet(req, resp);
	}
	
	public void setDynamicReportsManagedBean(
			DynamicReportsManagedBean dynamicReportsManagedBean) {
		this.dynamicReportsManagedBean = dynamicReportsManagedBean;
	}
	
	public DynamicReportsManagedBean getDynamicReportsManagedBean() {
		return dynamicReportsManagedBean;
	}
}
