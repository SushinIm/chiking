package com.sosam.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="mountain")
public class Mountain {
	@Id
	private String mcode;
	private String mname;
	private String sname;
	private String mreason;
	private String maddr;
	private String mdetail;
	private String mcourse;
	private String mheight;
}
