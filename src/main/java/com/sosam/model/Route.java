package com.sosam.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="route")
@IdClass(RouteIds.class)
public class Route {
	@Id
	private String routeid;
	@Id
	private String ordered;
	private float lat;
	private float lon;
	private float ele;
}
