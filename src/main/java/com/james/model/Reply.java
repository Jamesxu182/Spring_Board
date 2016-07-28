/**
 * 
 */
package com.james.model;

import java.time.Instant;

/**
 * @author james
 *
 */
public class Reply {
	private long id;
	private long discussionId;
	private String user;
	private String message;
	private Instant created;
	
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
	 * @return the discussionId
	 */
	public long getDiscussionId() {
		return discussionId;
	}
	
	/**
	 * @param discussionId the discussionId to set
	 */
	public void setDiscussionId(long discussionId) {
		this.discussionId = discussionId;
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
}
