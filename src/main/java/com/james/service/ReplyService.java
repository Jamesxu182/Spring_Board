package com.james.service;

import java.util.List;

import com.james.model.Reply;

public interface ReplyService {
	List<Reply> getRepliesForDiscussion(long discussionId);
	
	void saveReplay(Reply reply);
}
