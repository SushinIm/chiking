package com.sosam.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Data
@Entity(name="like")
@IdClass(LikeId.class)
public class Like {
	@Id
	private String mCode;
	@Id
	private String uId;
	
	private String likeYN;
}
