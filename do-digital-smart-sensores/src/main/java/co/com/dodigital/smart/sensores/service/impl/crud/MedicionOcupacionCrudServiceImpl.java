package co.com.dodigital.smart.sensores.service.impl.crud;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anexa.core.services.crud.impl.CrudServiceImpl;

import co.com.dodigital.smart.sensores.domain.MedicionOcupacion;
import co.com.dodigital.smart.sensores.dto.MedicionOcupacionDto;
import co.com.dodigital.smart.sensores.dto.MonitorDto;
import co.com.dodigital.smart.sensores.dto.SensorDto;
import co.com.dodigital.smart.sensores.dto.external.OcupacionDto;
import co.com.dodigital.smart.sensores.repository.MedicionOcupacionRepository;
import co.com.dodigital.smart.sensores.service.api.crud.MedicionOcupacionCrudService;
import co.com.dodigital.smart.sensores.service.api.crud.MonitorCrudService;
import co.com.dodigital.smart.sensores.service.api.crud.PuestoCrudService;
import co.com.dodigital.smart.sensores.service.api.crud.SensorCrudService;
import lombok.val;

@Service
public class MedicionOcupacionCrudServiceImpl extends CrudServiceImpl<MedicionOcupacion, MedicionOcupacionDto, Long>
		implements MedicionOcupacionCrudService {

	@Autowired
	private MonitorCrudService serviceMonitor;

	@Autowired
	private SensorCrudService serviceSensor;

	@Autowired
	private PuestoCrudService servicePuesto;

	@Autowired
	private MedicionOcupacionRepository repository;

	@Override
	protected MedicionOcupacionRepository getRepository() {
		return repository;
	}

	@Override
	protected MedicionOcupacionDto asModel(MedicionOcupacion entity) {
		val model = new MedicionOcupacionDto();

		model.setId(entity.getId());
		model.setIdSensor(entity.getIdSensor());
		model.setIdPuesto(entity.getIdPuesto());
		model.setIdPersona(entity.getIdPersona());
		model.setFechaMedicion(entity.getFechaMedicion());
		model.setCantidadPersonas(entity.getCantidadPersonas());
		model.setActividad(entity.getActividad());
		model.setInactividad(entity.getInactividad());
		model.setVersion(entity.getVersion());
		model.setFechaCreacion(entity.getFechaCreacion());
		model.setFechaModificacion(entity.getFechaModificacion());

		return model;
	}

	@Override
	protected MedicionOcupacion mergeEntity(MedicionOcupacionDto model, MedicionOcupacion entity) {

		entity.setIdSensor(model.getIdSensor());
		entity.setIdPuesto(model.getIdPuesto());
		entity.setIdPersona(model.getIdPersona());
		entity.setFechaMedicion(model.getFechaMedicion());
		entity.setCantidadPersonas(model.getCantidadPersonas());
		entity.setActividad(model.getActividad());
		entity.setInactividad(model.getInactividad());

		return entity;
	}

	@Override
	protected MedicionOcupacion newEntity() {
		return new MedicionOcupacion();
	}

	@Override
	public MedicionOcupacionDto create(OcupacionDto dto) {
		val model = new MedicionOcupacionDto();

		val monitor = findOneMonitorByCodigo(dto.getMonitor().toString());
		val sensor = findOneSensorByIdMonitorAndCodigo(monitor, dto.getSensor().toString());
		val puesto = servicePuesto.findOneById(sensor.getIdPuesto());

		model.setIdSensor(sensor.getId());
		model.setIdPuesto(sensor.getIdPuesto());
		model.setIdPersona(puesto.getIdPersona());
		model.setFechaMedicion(dto.getFechaHora());
		model.setCantidadPersonas(1);
		model.setActividad(dto.getActividad());
		model.setInactividad(dto.getInactividad());

		val result = create(model);
		return result;
	}

	public MonitorDto findOneMonitorByCodigo(String codigo) {
		val optional = serviceMonitor.findByCodigo(codigo);
		if (!optional.isPresent()) {
			throw new EntityNotFoundException("monitor = " + codigo);
		}
		val result = optional.get();
		return result;
	}

	public SensorDto findOneSensorByIdMonitorAndCodigo(MonitorDto monitor, String codigo) {
		val optional = serviceSensor.findByIdMonitorAndCodigo(monitor.getId(), codigo);
		if (!optional.isPresent()) {
			throw new EntityNotFoundException(String.format("monitor = %s,sensor = %s", monitor.getCodigo(), codigo));
		}
		val result = optional.get();
		return result;
	}

}