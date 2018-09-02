package com.anexa.mh.vtex.io.alertas.tasks;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.anexa.mh.vtex.io.alertas.service.api.MailService;
import com.anexa.mh.vtex.io.alertas.service.api.VtexAlertService;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Task {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private VtexAlertService alertService;

	@Autowired
	private MailService mailService;

	@Scheduled(cron = "${cron}")
	public void run() {
		try {
			log.debug("start alert service");
			val request = pull();
			log.debug("request.size()={}", request.size());
			if (!request.isEmpty()) {
				val mailMessage = alertService.getMessage(request);
				mailService.sendMail(mailMessage);
			}
		} catch (RuntimeException e) {
			log.error("catch (" + e.getClass().getSimpleName() + " e), exception:" + e.getMessage());
		}
	}

	protected List<String> pull() {
		val sql = getSQLSelect();

		val parametros = new MapSqlParameterSource();
		parametros.addValue("fechaDesde", LocalDate.now().minusDays(7));
		parametros.addValue("fechaHasta", LocalDate.now().plusDays(1));

		val result = jdbcTemplate.queryForList(sql, parametros, String.class);
		return result;
	}

	private String getSQLSelect() {
		// @formatter:off
		return "SELECT \r\n" 
				+ "    a.origenId\r\n" 
				+ "FROM dbo.Entradas a\r\n" 
				+ "LEFT OUTER JOIN dbo.Pedidos b ON\r\n"
				+ "    b.[integracion] = a.[integracion]\r\n" 
				+ "AND b.[origenId] = a.[origenId]\r\n"
				+ "AND b.clienteSincronizado = 1 \r\n" 
				+ "AND b.pedidoSincronizado = 1\r\n" 
				+ "WHERE\r\n"
				+ "    b.[integracion] IS NULL\r\n" 
				+ "AND a.fechaCreacion BETWEEN :fechaDesde AND :fechaHasta \r\n"
				+ "AND DATEDIFF(MINUTE,a.fechaCreacion,GETDATE()) > 30 \r\n"
				+ "ORDER BY\r\n" 
				+ "    a.fechaCreacion";
		// @formatter:on
	}
}