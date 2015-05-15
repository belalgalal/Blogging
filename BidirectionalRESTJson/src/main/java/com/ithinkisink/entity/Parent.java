package com.ithinkisink.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;


/**
 * The persistent class for the parent database table.
 * 
 */
@Entity
@NamedQuery(name="Parent.findAll", query="SELECT p FROM Parent p")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="parentId")
public class Parent implements Serializable {
	private static final long serialVersionUID = 1L;
	private int parentId;
	private String parentContent;
	private List<Child> childs;

	public Parent() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PARENT_ID")
	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	@Column(name="PARENT_CONTENT")
	public String getParentContent() {
		return this.parentContent;
	}

	public void setParentContent(String parentContent) {
		this.parentContent = parentContent;
	}


	//bi-directional many-to-one association to Child
	@OneToMany(mappedBy="parent")
	public List<Child> getChilds() {
		return this.childs;
	}

	public void setChilds(List<Child> childs) {
		this.childs = childs;
	}

	public Child addChild(Child child) {
		getChilds().add(child);
		child.setParent(this);

		return child;
	}

	public Child removeChild(Child child) {
		getChilds().remove(child);
		child.setParent(null);

		return child;
	}

}