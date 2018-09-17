package co.com.dodigital.smart.sensores.service.impl.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anexa.core.services.crud.impl.CrudServiceImpl;

import co.com.dodigital.smart.sensores.domain.Sensor;
import co.com.dodigital.smart.sensores.dto.SensorDto;
import co.com.dodigital.smart.sensores.repository.SensorRepository;
import co.com.dodigital.smart.sensores.service.api.crud.SensorCrudService;
import lombok.val;

@Service
public class SensorCrudServiceImpl extends CrudServiceImpl<Sensor, SensorDto, Long> implements SensorCrudService {

	@Autowired
	private SensorRepository repository;

	@Override
	protected SensorRepository getRepository() {
		return repository;
	}

	@Override
	protected SensorDto asModel(Sensor entity) {
		val model = new SensorDto();

		model.setId(entity.getId());
		model.setIdMonitor(entity.getIdMonitor());
		model.setCodigo(entity.getCodigo());
		model.setIdPuesto(entity.getIdPuesto());
		model.setActivo(entity.isActivo());
		model.setVersion(entity.getVersion());
		model.setFechaCreacion(entity.getFechaCreacion());
		model.setCreadoPor(entity.getCreadoPor());
		model.setFechaModificacion(entity.getFechaModificacion());
		model.setModificadoPor(entity.getModificadoPor());

		return model;
	}

	@Override
	protected Sensor mergeEntity(SensorDto model, Sensor entity) {

		entity.setIdMonitor(model.getIdMonitor());
		entity.setCodigo(model.getCodigo());
		entity.setIdPuesto(model.getIdPuesto());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Sensor newEntity() {
		return new Sensor();
	}

	@Override
	public Optional<SensorDto> findByIdMonitorAndCodigo(long idMonitor, String codigo) {
		val optional = getRepository().findByIdMonitorAndCodigo(idMonitor, codigo);
		val result = asModel(optional);
		return result;
	}
}