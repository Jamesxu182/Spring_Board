package com.james.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.james.form.ReplyForm;
import com.james.model.Discussion;
import com.james.model.Reply;
import com.james.service.DiscussionService;
import com.james.service.ReplyService;

@Controller
@RequestMapping("discussion/{discussionId:\\d+}")
public class DiscussionController {
	
	@Autowired DiscussionService discussionService;
	@Autowired ReplyService replyService;
	
	
	@RequestMapping(value = {"", "*"}, method = RequestMethod.GET)
	public String viewDiscussion(Map<String, Object> model, @PathVariable("discussionId") long id) {
		Discussion discussion = this.discussionService.getDiscussion(id);
		
		
		if(discussion != null) {
						
			model.put("discussion", discussion);
			model.put("replies", this.replyService.getRepliesForDiscussion(id));
			model.put("replyForm", new ReplyForm());
			
			return "discussion/view";
			
		} else {
			
			return "discussion/errorNoDiscussion";
			
		}
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public ModelAndView reply(ReplyForm form, @PathVariable("discussionId") long id) {
		Discussion discussion = this.discussionService.getDiscussion(id);
		
		if(discussion != null) {
			
			Reply reply = new Reply();
		
			reply.setId(0);
			reply.setDiscussionId(id);
			reply.setUser(form.getUser());
			reply.setMessage(form.getMessage());
			this.replyService.saveReplay(reply);
			
			return new ModelAndView(new RedirectView("/discussion/" + id + "/" + discussion.getUriSafeSubject(), true, false));
			
		} else {
			
			return new ModelAndView("discussion/errorNoDiscussion");
			
		}
	}
}
