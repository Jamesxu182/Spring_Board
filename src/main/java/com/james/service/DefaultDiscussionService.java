/**
 * 
 */
package com.james.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.model.Discussion;
import com.james.repository.DiscussionRepository;

/**
 * @author james
 *
 */
@Service
public class DefaultDiscussionService implements DiscussionService {
	
	@Autowired DiscussionRepository discussionRepository;
	
	/* (non-Javadoc)
	 * @see com.james.service.DiscussionService#getAllDiscussion()
	 */
	@Override
	public List<Discussion> getAllDiscussion() {
		// TODO Auto-generated method stub
		
		/* Get */
		List<Discussion> list = this.discussionRepository.getAll();
		
		/* Sort */
		list.sort((d1, d2) -> d1.getLastUpdated().compareTo(d2.getLastUpdated()));
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.james.service.DiscussionService#getDiscussion(long)
	 */
	@Override
	public Discussion getDiscussion(long id) {
		// TODO Auto-generated method stub
		
		Discussion discussion = this.discussionRepository.get(id);
		
		return discussion;
	}

	/* (non-Javadoc)
	 * @see com.james.service.DiscussionService#saveDiscussion(com.james.model.Discussion)
	 */
	@Override
	public void saveDiscussion(Discussion discussion) {
		// TODO Auto-generated method stub
		
		String subject = discussion.getSubject();
		
		discussion.setUriSafeSubject(subject);
		Instant now = Instant.now();
		discussion.setLastUpdated(now);
		
		if(discussion.getId() < 1) {
			/* create a new discussion */
			discussion.setCreated(now);
			discussion.getSubscribedUsers().add(discussion.getUser());
			this.discussionRepository.add(discussion);
			
		} else {
			
			this.discussionRepository.udpate(discussion);
			
		}

	}

}
