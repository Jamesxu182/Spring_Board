/**
 * 
 */
package com.james.repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.james.model.Reply;

/**
 * @author james
 *
 */
@Repository
public class InMemoryReplyRespository implements ReplyRepository {

	private final Map<Long, Reply> database = new Hashtable<>();
	private volatile long replyIdSequence = 1L;
	
	/* (non-Javadoc)
	 * @see com.james.repository.ReplyRepository#getForDiscussion(long)
	 */
	@Override
	public List<Reply> getForDiscussion(long id) {
		// TODO Auto-generated method stub
		return new ArrayList<>(this.database.values());
	}

	/* (non-Javadoc)
	 * @see com.james.repository.ReplyRepository#add(com.james.model.Reply)
	 */
	@Override
	public void add(Reply reply) {
		// TODO Auto-generated method stub
		reply.setId(this.getNextReplyId());
		
		database.put(reply.getId(), reply);
	}

	/* (non-Javadoc)
	 * @see com.james.repository.ReplyRepository#update(com.james.model.Reply)
	 */
	@Override
	public void update(Reply reply) {
		// TODO Auto-generated method stub
		database.put(reply.getId(), reply);
	}
	
	private synchronized long getNextReplyId() {
		return this.replyIdSequence++;
	}
}
