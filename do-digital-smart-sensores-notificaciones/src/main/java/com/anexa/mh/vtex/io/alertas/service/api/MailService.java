package com.anexa.mh.vtex.io.alertas.service.api;

import com.anexa.mh.vtex.io.alertas.dto.MailMessageDto;

public interface MailService {

	void sendMail(MailMessageDto mailMessage);
}