package com.sosam.hiking.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity(name="user")
public class User {
	@Id
	private String uId;
	private String uPw;
	private String pName;
	private String uHeight;
	private String uDiff;
	private String uLeng;
	private String uTime;
	private String uLoc;
}
