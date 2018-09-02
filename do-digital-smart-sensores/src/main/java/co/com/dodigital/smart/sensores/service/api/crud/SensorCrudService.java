package co.com.dodigital.smart.sensores.service.api.crud;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.anexa.core.services.crud.api.CrudService;

import co.com.dodigital.smart.sensores.dto.SensorDto;

@Transactional(readOnly = true)
public interface SensorCrudService extends CrudService<SensorDto, Long> {

	Optional<SensorDto> findByIdMonitorAndCodigo(long idMonitor, String codigo);
}
