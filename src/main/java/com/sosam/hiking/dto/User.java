package com.sosam.hiking.dto;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity(name="user")
public class User {
	private String uId;
	private String uPw;
	private String pName;
	private String uHeight;
	private String uDiff;
	private String uLeng;
	private String uTime;
	private String uLoc;
}
