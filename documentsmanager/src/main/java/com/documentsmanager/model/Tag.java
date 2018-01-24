package com.documentsmanager.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Kaan
 *
 */
@JsonInclude(value = Include.NON_NULL)
public class Tag implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean isPrimary;
	private String name;
	private String followingType;
	private long id;
	
	public Tag() {
		// TODO Auto-generated constructor stub
	}
	
	public Tag(boolean isPrimary, String name, String followingType, long id) {
		this.isPrimary = isPrimary;
		this.name = name;
		this.followingType = followingType;
		this.id = id;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFollowingType() {
		return followingType;
	}

	public void setFollowingType(String followingType) {
		this.followingType = followingType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
