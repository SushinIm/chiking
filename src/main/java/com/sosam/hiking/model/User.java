package com.sosam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="users")
public class User {
	@Id
	private String uid;
	private String upw;
	private String uname;
	private String uheight;
	private String udiff;
	private String utime;
	private String uloc;
}
