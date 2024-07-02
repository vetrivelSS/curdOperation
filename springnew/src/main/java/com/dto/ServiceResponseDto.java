package com.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "error")
public class ServiceResponseDto {

	public ServiceResponseDto(String message, List<String> description) {
		super();
		this.message = message;
		this.description = description;
	}



	@JsonProperty("messagecode")
	private String message;
	
	@JsonProperty("message")
	private List<String> description;

}
