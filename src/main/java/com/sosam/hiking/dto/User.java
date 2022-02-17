package com.sosam.hiking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
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
