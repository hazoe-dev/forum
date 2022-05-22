package com.ha.forum.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String username;
	private String password;
	private String email;
	private Date joinDate;
	private List<AMessage> messages = new ArrayList<AMessage>();
	private String formatTime;
}
