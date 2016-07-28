/**
 * 
 */
package com.james.repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.james.model.Discussion;

/**
 * @author james
 *
 */
@Repository
public class InMemoryDiscussionRepository implements DiscussionRepository {

	private final Map<Long, Discussion> database = new Hashtable<>();
	private volatile long discussionIdSequence = 1L;
	
	/* (non-Javadoc)
	 * @see com.james.repository.DiscussionRepository#getAll()
	 */
	@Override
	public List<Discussion> getAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(this.database.values());
	}

	/* (non-Javadoc)
	 * @see com.james.repository.DiscussionRepository#get(long)
	 */
	@Override
	public Discussion get(long id) {
		// TODO Auto-generated method stub
		return this.database.get(id);
	}

	/* (non-Javadoc)
	 * @see com.james.repository.DiscussionRepository#add(com.james.model.Discussion)
	 */
	@Override
	public void add(Discussion discussion) {
		// TODO Auto-generated method stub
		discussion.setId(this.getNextDiscussionId());
		this.database.put(discussion.getId(), discussion);

	}

	/* (non-Javadoc)
	 * @see com.james.repository.DiscussionRepository#udpate(com.james.model.Discussion)
	 */
	@Override
	public void udpate(Discussion discussion) {
		// TODO Auto-generated method stub
		this.database.put(discussion.getId(), discussion);

	}
	
	private synchronized long getNextDiscussionId() {
		return this.discussionIdSequence++;
	}

}
