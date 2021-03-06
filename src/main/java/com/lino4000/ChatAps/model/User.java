package com.lino4000.ChatAps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User{

	@Id @GeneratedValue
	private Integer id;
	@Column(unique=true)
	private String username;
	private String password;
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;
	private Boolean isLogged;
	private Boolean isActive;
}
