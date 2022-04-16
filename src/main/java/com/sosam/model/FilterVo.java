package com.sosam.model;

import lombok.Data;

@Data
public class FilterVo {
	private String keyword = null;
	private String mntnaddr = null;
	private int mntnhigh1 = 0;
	private int mntnhigh2 = 0;
	private int route1 = 0;
	private int route2 = 50;
}
