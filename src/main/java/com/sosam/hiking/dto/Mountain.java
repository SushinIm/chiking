package com.sosam.hiking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Mountain {
	private String mReason;
	private String mAddr;
	private String mDetail;
	private String mCourse;
	private String mHeight;
	private String mCode;
	private String mName;
	private String sName;
}
