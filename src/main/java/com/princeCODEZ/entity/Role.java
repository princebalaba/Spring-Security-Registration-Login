package com.princeCODEZ.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role_tbl")
public class Role {
	




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "role_name")
	private String name;
	
	public Role(String name) {
		super();
		this.name = name;
		
	}
	
	
	
	public enum roles{
		USER_ROLE,
		ADMIN_ROLE
	}

}
