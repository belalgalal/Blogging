package com.ithinkisink.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the child database table.
 * 
 */
@Entity
@NamedQuery(name="Child.findAll", query="SELECT c FROM Child c")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="childId")
public class Child implements Serializable {
	private static final long serialVersionUID = 1L;
	private int childId;
	private String childContent;
	private Parent parent;

	public Child() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CHILD_ID")
	public int getChildId() {
		return this.childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}


	@Column(name="CHILD_CONTENT")
	public String getChildContent() {
		return this.childContent;
	}

	public void setChildContent(String childContent) {
		this.childContent = childContent;
	}


	//bi-directional many-to-one association to Parent
	@ManyToOne(fetch=FetchType.LAZY)
	public Parent getParent() {
		return this.parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

}