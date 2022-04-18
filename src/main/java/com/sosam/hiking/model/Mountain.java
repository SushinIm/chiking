package com.sosam.hiking.model;


import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity(name="mountain")
public class Mountain {
	@Id
	private String mntnid;
	private String reason;
	private String mntnname;
	private String mntnsname;
	private String mntnaddr;
	private float mntnhigh;
	private String mntnadmin;
	private String mntnadmnum;
	private String mntidetail;
	private int routes;

	@ToString.Exclude
    @OneToMany(mappedBy = "mountain", fetch=FetchType.LAZY)  
    private List<MRMapping> mrmappings = new LinkedList<>();
}
