/**
 * 
 */
package com.james.repository;

import java.util.List;

import com.james.model.Reply;

/**
 * @author james
 *
 */
public interface ReplyRepository {
	List<Reply> getForDiscussion(long id);
	
	void add(Reply reply);
	
	void update(Reply reply);
}
