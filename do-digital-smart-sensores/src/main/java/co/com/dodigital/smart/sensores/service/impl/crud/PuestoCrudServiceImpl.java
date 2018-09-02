package co.com.dodigital.smart.sensores.service.impl.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anexa.core.services.crud.impl.CrudServiceImpl;

import co.com.dodigital.smart.sensores.domain.Puesto;
import co.com.dodigital.smart.sensores.dto.PuestoDto;
import co.com.dodigital.smart.sensores.repository.PuestoRepository;
import co.com.dodigital.smart.sensores.service.api.crud.PuestoCrudService;
import lombok.val;

@Service
public class PuestoCrudServiceImpl extends CrudServiceImpl<Puesto, PuestoDto, Long> implements PuestoCrudService {

	@Autowired
	private PuestoRepository repository;

	@Override
	protected PuestoRepository getRepository() {
		return repository;
	}

	@Override
	protected PuestoDto asModel(Puesto entity) {
		val model = new PuestoDto();

		model.setId(entity.getId());
		model.setIdZona(entity.getIdZona());
		model.setCodigo(entity.getCodigo());
		model.setIdPersona(entity.getIdPersona());
		model.setActivo(entity.isActivo());
		model.setVersion(entity.getVersion());
		model.setFechaCreacion(entity.getFechaCreacion());
		model.setCreadoPor(entity.getCreadoPor());
		model.setFechaModificacion(entity.getFechaModificacion());
		model.setModificadoPor(entity.getModificadoPor());

		return model;
	}

	@Override
	protected Puesto asEntity(PuestoDto model, Puesto entity) {

		entity.setIdZona(model.getIdZona());
		entity.setCodigo(model.getCodigo());
		entity.setIdPersona(model.getIdPersona());
		entity.setActivo(model.isActivo());

		return entity;
	}

	@Override
	protected Puesto newEntity() {
		return new Puesto();
	}
}