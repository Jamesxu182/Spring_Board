/**
 * 
 */
package com.james.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.james.form.DiscussionForm;
import com.james.model.Discussion;
import com.james.service.DiscussionService;

/**
 * @author james
 *
 */
@Controller
@RequestMapping("discussion")
public class BoardController {

	@Autowired
	DiscussionService discussionService;
	
	@RequestMapping(value = {"", "list"}, method = RequestMethod.GET)
	public String listDiscussions(Map<String, Object> model) {
		
		model.put("discussions", discussionService.getAllDiscussion());
		
		return "discussion/list";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createDiscussion(Map<String, Object> model) {
		
		model.put("discussionForm", new DiscussionForm());
		
		return "discussion/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public View createDiscussion(DiscussionForm form) {
		Discussion discussion = new Discussion();
		discussion.setId(0);
		discussion.setUser(form.getUser());
		discussion.setSubject(form.getSubject());
		discussion.setMessage(form.getMessage());
		
		this.discussionService.saveDiscussion(discussion);
		
		return new RedirectView("/discussion/" + discussion.getId() + "/" + discussion.getUriSafeSubject(), true, false);
	}	
}
