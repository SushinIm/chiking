package com.sosam.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LikeId implements Serializable{
	private String mCode;
	private String uId;
}
