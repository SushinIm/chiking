package com.sosam.hiking.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity(name="mountain")
public class Mountain {
	private String mReason;
	private String mAddr;
	private String mDetail;
	private String mCourse;
	private String mHeight;
	@Id
	private String mCode;
	private String mName;
	private String sName;
}
