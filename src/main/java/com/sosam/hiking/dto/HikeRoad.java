package com.sosam.hiking.dto;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity(name="hikeroad")
public class HikeRoad {
	private String pmCode;
	private String mCode;
	private String mName;
	private String pmName;
	private String pmLeng;
	private String pmDiff;
	private String pmUp;
	private String pmDown;
}
