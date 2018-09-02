package co.com.dodigital.smart.sensores.service.api.crud;

import org.springframework.transaction.annotation.Transactional;

import com.anexa.core.services.crud.api.CrudService;

import co.com.dodigital.smart.sensores.dto.PuestoDto;

@Transactional(readOnly = true)
public interface PuestoCrudService extends CrudService<PuestoDto, Long> {

}
