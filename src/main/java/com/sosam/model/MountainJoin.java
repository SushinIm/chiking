package com.sosam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MountainJoin {
	private String mcode;
	private String mname;
	private String sname;
	private String mreason;
	private String mdetail;
	private String mcourse;
	private String mheight;
	private String pmup;
	private String pmdown;
	private String pmdiff;
	private String cult;
	private String uid;
	private String likeyn;
	
	private String keyword;
	private String maddr;
	private String mdiff;
	private int mheight1;
	private int mheight2;
	private int mtime1;
	private int mtime2;
}
