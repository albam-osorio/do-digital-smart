package co.com.dodigital.smart.sensores.service.api.crud;

import org.springframework.transaction.annotation.Transactional;

import com.anexa.core.services.crud.api.CrudService;

import co.com.dodigital.smart.sensores.dto.MedicionOcupacionDto;
import co.com.dodigital.smart.sensores.dto.external.OcupacionDto;

@Transactional(readOnly = true)
public interface MedicionOcupacionCrudService extends CrudService<MedicionOcupacionDto, Long> {

	@Transactional
	MedicionOcupacionDto create(OcupacionDto model);
}
