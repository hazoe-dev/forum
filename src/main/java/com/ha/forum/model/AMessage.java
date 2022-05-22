package com.ha.forum.model;

import java.util.Calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AMessage {
	private String title;
	private Calendar createdTime;
	private String content;
	private User creator;
	private String formatTime;

}
