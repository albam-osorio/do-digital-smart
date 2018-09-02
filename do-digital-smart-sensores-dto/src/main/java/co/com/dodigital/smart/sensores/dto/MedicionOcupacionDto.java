package co.com.dodigital.smart.sensores.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import co.com.dodigital.commons.dto.BusinessEntityDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class MedicionOcupacionDto extends BusinessEntityDto<Long> {

	private long idSensor;

	private long idPuesto;

	private Long idPersona;

	@NotNull
	private LocalDateTime fechaMedicion;

	private int cantidadPersonas;

	private int actividad;

	private int inactividad;

}
