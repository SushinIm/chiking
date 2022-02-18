package com.sosam.hiking.dto;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity(name="like")
public class Like {
	private String mCode;
	private String uId;
	private String likeYN;
}
