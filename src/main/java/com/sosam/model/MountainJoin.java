package com.sosam.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MountainJoin {
	private String mCode;
	private String mName;
	private String sName;
	private String mReason;
	private String mAddr;
	private String mDetail;
	private String mCourse;
	private String mHeight;
	private String pmLeng;
	private String pmDiff;
	private String pmUp;
	private String pmDown;
}
