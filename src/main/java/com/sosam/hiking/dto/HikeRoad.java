package com.sosam.hiking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
public class HikeRoad {
	private String pmCode;
	private String mCode;
	private String mName;
	private String pmName;
	private String pmLeng;
	private String pmDiff;
	private String pmUp;
	private String pmDown;
}
