package com.lino4000.ChatAps.model;

import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Login {

	@Transient
	private String username;
	@Transient
	private String password;
}
