package com.anexa.mh.vtex.io.alertas.configuration;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Validated
public class MailProperties {

	private String from;
	
	private String fromPersonal;

	private String[] to;

	private String[] cc;

	private String subject;

}