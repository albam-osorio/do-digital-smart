package co.com.dodigital.smart.sensores.repository;

import com.anexa.core.data.jpa.repository.IdentifiedDomainObjectRepository;
import com.anexa.core.data.jpa.repository.QueryByCodigo;

import co.com.dodigital.smart.sensores.domain.Monitor;

public interface MonitorRepository extends IdentifiedDomainObjectRepository<Monitor, Long>, QueryByCodigo<Monitor, Long> {

}