package co.com.dodigital.smart.sensores.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anexa.core.domain.InactivableObject;

import co.com.dodigital.commons.dto.BusinessEntityDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class PuestoDto extends BusinessEntityDto<Long> implements InactivableObject {

	@NotNull
	private Long idZona;

	@NotNull
	@Size(max = 50)
	private String codigo;

	private Long idPersona;

	private boolean activo;

}
