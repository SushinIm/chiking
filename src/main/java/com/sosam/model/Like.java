package com.sosam.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="liketbl")
public class Like implements Serializable{
	@EmbeddedId
	private LikeId likeid;
	
	private String likeyn;
}
