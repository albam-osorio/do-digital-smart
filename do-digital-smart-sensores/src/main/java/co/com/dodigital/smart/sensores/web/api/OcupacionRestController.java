package co.com.dodigital.smart.sensores.web.api;

import javax.validation.Valid;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.dodigital.smart.sensores.constants.RestConstantsV1;
import co.com.dodigital.smart.sensores.dto.external.OcupacionDto;
import co.com.dodigital.smart.sensores.service.api.crud.MedicionOcupacionCrudService;
import lombok.val;

@RestController
@RequestMapping(value = RestConstantsV1.ocupaciones, produces = MediaType.APPLICATION_JSON_VALUE)
public class OcupacionRestController {

	@Autowired
	private MedicionOcupacionCrudService service;

	protected MedicionOcupacionCrudService getService() {
		return service;
	}

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody OcupacionDto model, BindingResult bindingResult) {
		if (model.getId() != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

		if (!bindingResult.hasErrors()) {
			try {
				val result = getService().create(model);

				return ResponseEntity.ok(result.getId());
			} catch (RuntimeException e) {
				val t = ExceptionUtils.getRootCause(e);
				bindingResult.reject(t.getClass().getName(), t.getMessage());
			}
		}

		return ResponseEntity.status(HttpStatus.CONFLICT).body(bindingResult.getAllErrors());
	}
}
