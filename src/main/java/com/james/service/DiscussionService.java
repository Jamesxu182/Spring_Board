/**
 * 
 */
package com.james.service;

import java.util.List;

import com.james.model.Discussion;

/**
 * @author james
 *
 */
public interface DiscussionService {
	List<Discussion> getAllDiscussion();
	
	Discussion getDiscussion(long id);
	
	void saveDiscussion(Discussion discussion);
}
