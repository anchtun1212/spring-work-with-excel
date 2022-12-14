package com.anchtun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "final_result")
public class FinalResultEntity {
	
	@Id
	private String id;
	
	private String exam;
	
	@Column(name = "student_full_name")
	private String studentFullName;
	
	private Double note;

}
