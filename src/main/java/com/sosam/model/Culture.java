package com.sosam.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="culture")
public class Culture {
	@Id
	private String cId;
	private String mCode;
	private String mName;
	private String cName;
	private String cLot;
	private String cLat;
	private String cHeight;
	private String cDetail;
	private String cType;
}
