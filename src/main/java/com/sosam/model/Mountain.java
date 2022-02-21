package com.sosam.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
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
