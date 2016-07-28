/**
 * 
 */
package com.james.model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * @author james
 *
 */
public class Discussion {
	private long id;
	private String user;
	private String subject;
	private String uriSafeSubject;
	private String message;
	private Instant created;
	private Instant lastUpdated;
	private Set<String> subscribedUsers = new HashSet<>();
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * @return the uriSafeSubject
	 */
	public String getUriSafeSubject() {
		return uriSafeSubject;
	}
	
	/**
	 * @param uriSafeSubject the uriSafeSubject to set
	 */
	public void setUriSafeSubject(String uriSafeSubject) {
		this.uriSafeSubject = uriSafeSubject;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @return the created
	 */
	public Instant getCreated() {
		return created;
	}
	
	/**
	 * @param created the created to set
	 */
	public void setCreated(Instant created) {
		this.created = created;
	}
	
	/**
	 * @return the lastUpdated
	 */
	public Instant getLastUpdated() {
		return lastUpdated;
	}
	
	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(Instant lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	/**
	 * @return the subscribedUsers
	 */
	public Set<String> getSubscribedUsers() {
		return subscribedUsers;
	}
	
	/**
	 * @param subscribedUsers the subscribedUsers to set
	 */
	public void setSubscribedUsers(Set<String> subscribedUsers) {
		this.subscribedUsers = subscribedUsers;
	}
}
