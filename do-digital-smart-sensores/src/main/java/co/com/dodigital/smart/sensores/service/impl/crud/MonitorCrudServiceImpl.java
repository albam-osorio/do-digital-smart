package co.com.dodigital.smart.sensores.service.impl.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anexa.core.services.crud.impl.CrudServiceImpl;

import co.com.dodigital.smart.sensores.domain.Monitor;
import co.com.dodigital.smart.sensores.dto.MonitorDto;
import co.com.dodigital.smart.sensores.repository.MonitorRepository;
import co.com.dodigital.smart.sensores.service.api.crud.MonitorCrudService;
import lombok.val;

@Service
public class MonitorCrudServiceImpl extends CrudServiceImpl<Monitor, MonitorDto, Long> implements MonitorCrudService {

	@Autowired
	private MonitorRepository repository;

	@Override
	protected MonitorRepository getRepository() {
		return repository;
	}

	@Override
	protected MonitorDto asModel(Monitor entity) {
		val model = new MonitorDto();

		model.setId(entity.getId());
		model.setCodigo(entity.getCodigo());
		model.setVersion(entity.getVersion());
		model.setFechaCreacion(entity.getFechaCreacion());
		model.setCreadoPor(entity.getCreadoPor());
		model.setFechaModificacion(entity.getFechaModificacion());
		model.setModificadoPor(entity.getModificadoPor());

		return model;
	}

	@Override
	protected Monitor asEntity(MonitorDto model, Monitor entity) {

		entity.setCodigo(model.getCodigo());
		
		return entity;
	}

	@Override
	protected Monitor newEntity() {
		return new Monitor();
	}

	@Override
	public Optional<MonitorDto> findByCodigo(String codigo) {
		val optional = getRepository().findByCodigo(codigo);
		val result = asModel(optional);
		return result;
	}
}