/**
 * 
 */
package com.james.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.model.Discussion;
import com.james.model.Reply;
import com.james.repository.ReplyRepository;

/**
 * @author james
 *
 */
@Service
public class DefaultReplyService implements ReplyService {
	@Autowired ReplyRepository replyRepository;
	@Autowired DiscussionService discussionService;

	/* (non-Javadoc)
	 * @see com.james.service.ReplyService#getRepliesForDiscussion(long)
	 */
	@Override
	public List<Reply> getRepliesForDiscussion(long discussionId) {
		// TODO Auto-generated method stub
		
		List<Reply> list = this.replyRepository.getForDiscussion(discussionId);
		list.sort((r1, r2) -> r1.getId() < r2.getId() ? -1 : 1);
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.james.service.ReplyService#saveReplay(com.james.model.Reply)
	 */
	@Override
	public void saveReplay(Reply reply) {
		// TODO Auto-generated method stub
		
		Discussion discussion = this.discussionService.getDiscussion(reply.getDiscussionId());
		
		if(reply.getId() < 1) {
			/* create new reply */
			discussion.getSubscribedUsers().add(reply.getUser());
			reply.setCreated(Instant.now());
			this.replyRepository.add(reply);
		} else {
			this.replyRepository.update(reply);
		}
		
		this.discussionService.saveDiscussion(discussion);

	}

}
