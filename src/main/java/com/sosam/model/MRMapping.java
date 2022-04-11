package com.sosam.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.ToString;

@Data
@Entity(name="mrmapping")
public class MRMapping {
	@Id
	private String routeid;
	private String routename;

    @ManyToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name="mntnid")  
    @JsonBackReference  
	@ToString.Exclude
    private Mountain mountain;
    
    private float distance;
}
