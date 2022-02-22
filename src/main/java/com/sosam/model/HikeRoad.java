package com.sosam.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="hikeroad")
public class HikeRoad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String pmcode;
	private String mcode;
	private String mname;
	private String pmname;
	private String pmleng;
	private String pmdiff;
	private String pmup;
	private String pmdown;
}
