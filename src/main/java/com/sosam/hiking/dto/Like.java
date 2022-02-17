package com.sosam.hiking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Like {
	private String mCode;
	private String uId;
	private String likeYN;
}
