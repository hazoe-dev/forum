package com.ha.forum.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Forum {
	private String title;
	private List<Forum> subForums = new ArrayList<Forum>();
	private List<Topic> topics = new ArrayList<>();

	public int addTopic(Topic topic) {
		int last = topics.size()>0? topics.size()-1:-1;
		int id = last >-1?topics.get(last).getId()+1:1;
		topic.setId(id);
		topics.add(topic);
		return id;
	}
	
	public Topic getTopic(int id) {
		for (Topic topic : topics) {
			if(topic.getId() == id) {
				 return  topic;
			}
		}
		return null;
	}
}
