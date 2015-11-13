package com.sample.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SampleDTO implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String serviceId;
	private String host;
	private Integer port;

}
