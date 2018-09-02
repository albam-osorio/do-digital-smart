package co.com.dodigital.smart.sensores.repository;

import java.util.Optional;

import com.anexa.core.data.jpa.repository.IdentifiedDomainObjectRepository;

import co.com.dodigital.smart.sensores.domain.Sensor;

public interface SensorRepository extends IdentifiedDomainObjectRepository<Sensor, Long> {

	Optional<Sensor> findByIdMonitorAndCodigo(long idMonitor, String codigo);

}