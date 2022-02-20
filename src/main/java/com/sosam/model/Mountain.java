package com.sosam.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	/*
	 * @OneToMany(mappedBy = "mountain", fetch=FetchType.LAZY) private
	 * List<MntnFilter> MntnFilterList = new LinkedList<>();
	 */
}
