package com.ha.forum.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic extends AMessage{
	private int id;
	List<AMessage> messages = new ArrayList<AMessage>();
	
	public Topic(int id, String title, Calendar createdTime, String content, User creator, String formatTime ) {
		super( title, createdTime, content, creator, formatTime);
		this.id= id;
	}
}
