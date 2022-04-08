package com.sosam.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
public class RouteIds implements Serializable{
	private String routeid;
	private String ordered;
}
