package com.sosam.hiking.dto;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity(name="culture")
public class Culture {
	private String mId;
	private String mName;
	private String cName;
	private String cLot;
	private String cLat;
	private String cHeight;
	private String cDetail;
	private String cType;
	private String cId;
}
