package com.sosam.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity(name="mountain")
public class Mountain {
	@Id
	private String mCode;
	private String mName;
	private String sName;
	private String mReason;
	private String mAddr;
	private String mDetail;
	private String mCourse;
	private String mHeight;

	@OneToMany(mappedBy = "mountain", fetch=FetchType.LAZY)
	private List<HikeRoad> hikeRoadList = new LinkedList<>();
 
}
