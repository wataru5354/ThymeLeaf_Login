package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;

public class UserForm {
	@NotBlank
	private String loginId;
	@NotBlank
	private String loginPassword;
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
}
