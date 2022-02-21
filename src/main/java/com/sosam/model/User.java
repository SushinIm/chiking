package com.sosam.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="user")
public class User {
	@Id
	private String uId;
	private String uPw;
	private String uName;
	private String uHeight;
	private String uDiff;
	private String uLeng;
	private String uTime;
	private String uLoc;
}
