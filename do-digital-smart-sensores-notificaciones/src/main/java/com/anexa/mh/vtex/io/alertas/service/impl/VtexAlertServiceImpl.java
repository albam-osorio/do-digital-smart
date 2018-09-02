package com.anexa.mh.vtex.io.alertas.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anexa.mh.vtex.io.alertas.configuration.MailProperties;
import com.anexa.mh.vtex.io.alertas.dto.MailMessageDto;
import com.anexa.mh.vtex.io.alertas.service.api.VtexAlertService;

import lombok.val;

@Service
public class VtexAlertServiceImpl extends AlertServiceImpl<List<String>, MailMessageDto> implements VtexAlertService {

	protected static final String ALERT_CODE = "VETXT_CHAT";

	@Autowired
	private MailProperties properties;

	@Override
	protected String getCode() {
		return ALERT_CODE;
	}

	@Override
	protected String getSubject() {
		return properties.getSubject();
	}

	@Override
	protected Map<String, Object> getData(List<String> request) {
		val result = new HashMap<String, Object>();
		val sb = new StringBuilder();

		for (val orderId : request) {
			sb.append("<h2>").append(orderId).append("</h2>\n");
		}
		result.put("pedidos", sb.toString());

		return result;
	}

	@Override
	protected String getContentPathResource() {
		return "templates\\alert.html";
	}

	@Override
	protected MailMessageDto createMessage(String code, String subject, String content, File[] attachments) {
		return new MailMessageDto(code, subject, content, attachments);
	}
}
