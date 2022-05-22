package com.ha.forum.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ha.forum.model.Forum;
import com.ha.forum.model.IForumData;
import com.ha.forum.model.ReplyMessage;
import com.ha.forum.model.Topic;
import com.ha.forum.model.User;

import lombok.Data;

@Controller
@RequestMapping("/")
public class ForumController {
	@Autowired
	HttpSession httpSession;

	@Autowired
	IForumData forumData;

	@GetMapping()
	public ModelAndView getLogin() {
		ModelAndView mav = new ModelAndView("login");
		httpSession.setAttribute("a", "a");
		return mav;
	}

	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute LoginForm form) {
		ModelAndView mav = new ModelAndView("login");
		User user = forumData.checkUser(form.getUsername(), form.getPassword());
		if (user != null) {
			httpSession.setAttribute("user", user);
			return new ModelAndView("redirect:/list");
		} else {
			return mav;
		}
	}

	@GetMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView("login");
		httpSession.invalidate();
		return mav;
	}

	@GetMapping("/list")
	public ModelAndView listTopics() {
		if ((User) httpSession.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView("listTopics");
		Forum forum = forumData.getForums().get(0);
		mav.addObject(forum);
		return mav;
	}
	
	@GetMapping("/topic/{id}")
	public ModelAndView getTopic(@PathVariable int id) {
		if ((User) httpSession.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav = new ModelAndView("showTopic");
		Topic topic = forumData.getForums().get(0).getTopic(id);
		mav.addObject(topic);
		return mav;
	}
	
	@GetMapping("/topic")
	public ModelAndView showNewTopic() {
		if ((User) httpSession.getAttribute("user") == null) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("newTopic");
	}
	
	@PostMapping("/newtopic")
	public ModelAndView createTopic(@ModelAttribute MessageForm form) {
		User user =(User) httpSession.getAttribute("user");
		if ( user== null) {
			return new ModelAndView("redirect:/");
		}
		Topic topic = new Topic();
		topic.setContent( form.getContent());
		topic.setTitle(form.getTitle());
		topic.setCreator(user);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		topic.setCreatedTime(c);
		topic.setFormatTime(sdf.format(c.getTime()));
		
		int id = forumData.getForums().get(0).addTopic(topic);
		return new ModelAndView("redirect:/topic/"+id);
	}
	
	@GetMapping("/reply")
	public ModelAndView reply(@ModelAttribute ReplyForm form) {
		User user =(User) httpSession.getAttribute("user");
		if ( user== null) {
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav= new ModelAndView("replyTopic");
		httpSession.setAttribute("id", form.getId());
		httpSession.setAttribute("title", form.getTitle());
		return new ModelAndView("redirect:/replypage");
	}
	
	@GetMapping("/replypage")
	public ModelAndView reply() {
		User user =(User) httpSession.getAttribute("user");
		if ( user== null) {
			return new ModelAndView("redirect:/");
		}
		
		return new ModelAndView("replyTopic");
	}
	
	@PostMapping("/newreply")
	public ModelAndView createReply(@ModelAttribute MessageReplyForm form) {
		User user =(User) httpSession.getAttribute("user");
		if ( user== null) {
			return new ModelAndView("redirect:/");
		}
		ReplyMessage message = new ReplyMessage();
		message.setContent( form.getContent());
		message.setTitle(form.getTitle());
		message.setCreator(user);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		message.setCreatedTime(c);
		message.setFormatTime(sdf.format(c.getTime()));
		int id = form.getId();
		Topic topic = forumData.getForums().get(0).getTopic(id);
		topic.getMessages().add(message);
		return new ModelAndView("redirect:/topic/"+id);
	}
}
@Data
class MessageForm {
	private String title;
	private String content;
}

@Data
class MessageReplyForm {
	private int id;
	private String title;
	private String content;
}
@Data
class LoginForm {
	private String username;
	private String password;
}
@Data
class ReplyForm {
	private int id;
	private String title;
}
