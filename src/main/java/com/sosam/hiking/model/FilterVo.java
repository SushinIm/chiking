package com.sosam.hiking.model;

import lombok.Data;

@Data
public class FilterVo {
	private String keyword;
	private String mntnaddr;
	private int mntnhigh1;
	private int mntnhigh2;
	private int route1;
	private int route2;
}
