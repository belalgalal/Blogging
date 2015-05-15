package com.ithinkisink.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

	@PersistenceContext(unitName="BidirectionalPU")
	protected EntityManager entityManager;
	
	@GET
	@Path("/retrieveParentWithChildren")
	@Produces(MediaType.APPLICATION_JSON)
	public Parent retrieveParentWithChildren() {
		int parentId = 1;
		Query q = entityManager.createQuery("SELECT p FROM " + "Parent " + "p JOIN FETCH p.childs WHERE p.parentId = :parentId ");
		q.setParameter("parentId", parentId);
		return (q.getResultList().size() > 0) ? (Parent) q.getResultList().get(0) : null;
	}
	
	@GET
	@Path("/retrieveChildWithParent")
	@Produces(MediaType.APPLICATION_JSON)
	public Child retrieveChildWithParent() {
		int childId = 1;
		Query q = entityManager.createQuery("SELECT c FROM " + "Child " + "c JOIN FETCH c.parent WHERE c.childId = :childId ");
		q.setParameter("childId", childId);
		return (q.getResultList().size() > 0) ? (Child) q.getResultList().get(0) : null;
	}
}
