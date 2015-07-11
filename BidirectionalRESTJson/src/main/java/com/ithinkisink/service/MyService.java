package com.ithinkisink.service;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ithinkisink.entity.Child;
import com.ithinkisink.entity.Parent;

/**
 * 
 * @author Belal
 *
 */
@Path("MyService")
public class MyService {

	@EJB
	MyServiceDAO myServiceDAO;
	
	@GET
	@Path("/retrieveParentWithChildren")
	@Produces(MediaType.APPLICATION_JSON)
	public Parent retrieveParentWithChildren() {
		return myServiceDAO.retrieveParentWithChildren();
	}
	
	@GET
	@Path("/retrieveChildWithParent")
	@Produces(MediaType.APPLICATION_JSON)
	public Child retrieveChildWithParent() {
		return myServiceDAO.retrieveChildWithParent();
	}
}
