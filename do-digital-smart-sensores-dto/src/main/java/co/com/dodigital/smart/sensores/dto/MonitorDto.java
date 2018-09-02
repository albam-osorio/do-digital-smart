package co.com.dodigital.smart.sensores.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.anexa.core.domain.ObjectWithCode;

import co.com.dodigital.commons.dto.BusinessEntityDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class MonitorDto extends BusinessEntityDto<Long> implements ObjectWithCode<Long>{

	@NotNull
	@Size(max = 50)
	private String codigo;

}
