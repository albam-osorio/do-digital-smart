package co.com.dodigital.smart.sensores.dto.external;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.anexa.core.dto.EntityDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class OcupacionDto extends EntityDto<Long>{

	@NotNull
	private Long monitor;
	
	@NotNull
	private Long sensor;

	@NotNull
	private LocalDateTime fechaHora;

	@NotNull
	private Integer actividad;

	@NotNull
	private Integer inactividad;
}
