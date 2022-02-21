package com.sosam.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity(name="hikeroad")
public class HikeRoad {
	@Id
	private String pmCode;
	private String mCode;
	private String mName;
	private String pmName;
	private String pmLeng;
	private String pmDiff;
	private String pmUp;
	private String pmDown;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="mCode")
	@JsonBackReference
	private Mountain mountain;
}
