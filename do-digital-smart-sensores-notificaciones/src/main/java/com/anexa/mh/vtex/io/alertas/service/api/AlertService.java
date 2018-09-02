package com.anexa.mh.vtex.io.alertas.service.api;

import org.springframework.transaction.annotation.Transactional;

public interface AlertService<R, M> {

	@Transactional
	M getMessage(R request);

	@Transactional
	M getMessage(R request, Throwable t);
}