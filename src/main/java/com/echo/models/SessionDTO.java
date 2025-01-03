package com.echo.models;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionDTO {
	
	private String token;
	
	private String message;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
