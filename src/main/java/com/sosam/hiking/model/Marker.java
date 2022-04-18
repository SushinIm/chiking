package com.sosam.hiking.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="marker")
public class Marker {
	@Id
	private String markerid;
	private String category;
	private float lat;
	private float lon;
	private float ele;
	private String name;
	private String routeid;
}
