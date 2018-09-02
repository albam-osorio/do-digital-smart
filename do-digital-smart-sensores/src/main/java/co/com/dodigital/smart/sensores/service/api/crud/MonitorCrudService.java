package co.com.dodigital.smart.sensores.service.api.crud;

import org.springframework.transaction.annotation.Transactional;

import com.anexa.core.services.crud.api.CrudService;
import com.anexa.core.services.crud.api.QueryByCodigoService;

import co.com.dodigital.smart.sensores.dto.MonitorDto;

@Transactional(readOnly = true)
public interface MonitorCrudService extends CrudService<MonitorDto, Long> , QueryByCodigoService<MonitorDto, Long> {

}
