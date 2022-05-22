package com.ha.forum.model;

import java.util.Calendar;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@Getter
public class ReplyMessage extends AMessage {
	public ReplyMessage( String title, Calendar createdTime, String content, User creator, String formatTime) {
		super( title, createdTime, content, creator, formatTime);
	}
}
