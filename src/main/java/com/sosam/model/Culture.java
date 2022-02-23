package com.sosam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="culture")
public class Culture {
	@Id
	private String cid;
	private String mcode;
	private String mname;
	private String cname;
	private String clot;
	private String clat;
	private String cheight;
	private String cdetail;
	private String ctype;
}
