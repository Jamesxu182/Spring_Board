package com.james.repository;

import java.util.List;

import com.james.model.Discussion;

public interface DiscussionRepository {
	
	List<Discussion> getAll();
	
	Discussion get(long id);
	
	void add(Discussion discussion);
	
	void udpate(Discussion discussion);
}
