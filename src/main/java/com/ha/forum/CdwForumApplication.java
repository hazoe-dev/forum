package com.ha.forum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ha.forum.model.AMessage;
import com.ha.forum.model.Forum;
import com.ha.forum.model.IForumData;
import com.ha.forum.model.ReplyMessage;
import com.ha.forum.model.Topic;
import com.ha.forum.model.User;

@SpringBootApplication
public class CdwForumApplication {
	@Autowired
	IForumData forumData;

	public static void main(String[] args) {
		SpringApplication.run(CdwForumApplication.class, args);
	}
	/*
	 * SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
	
	Calendar calendar = Calendar.getInstance();
        Date date =  calendar.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");	
	Calendar calendar = new GregorianCalendar(2013,0,31);
	System.out.println(sdf.format(calendar.getTime()));
	 */
	@Bean
	void initData() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		
		Date d = new Date();
		List<AMessage> l =new ArrayList<AMessage>();
		User u = new User("a","123","a@a",d,l,sdf.format(d));
		Date d1 = new Date();
		User u1 = new User("Van Da","123","a@a",d1,l,sdf.format(d1));
		forumData.getUsers().add(u);
		
		Calendar c1 = Calendar.getInstance();
		ReplyMessage reply1= new ReplyMessage( "Gợi ý sách", c1, "Xin chào thầy và các bạn, em muốn hỏi về một số cuốn sách hay. Mong mọi người góp ý ạ! *v* ", u1,sdf.format(c1.getTime()));
		
		
		Calendar c2 = Calendar.getInstance();
		ReplyMessage reply2= new ReplyMessage( "Re:Gợi ý sách", c2, "Blink!", u1,sdf.format(c2.getTime()));
		

		
		List<Topic> topics = new ArrayList<>();
		Calendar calendar = new GregorianCalendar(2022,0,31);
		
		Topic topic = new Topic(1, "Book?",calendar,"How to choose book?", u,sdf.format(calendar.getTime()));
		topics.add(topic);
		
		topic.getMessages().add(reply1);
		topic.getMessages().add(reply2);
		
		Topic topic2 = new Topic(2, "Topic Chuyện học phí!!!",calendar,"Học phí từ lớp 1 đến 12 và đại học/ cao đẳng", u,sdf.format(calendar.getTime()));
		topics.add(topic2);
		
		

		
		Forum forum = new Forum("Chuyện đọc sách forum",new ArrayList<>(),topics);
		forumData.getForums().add(forum);
	}
}
