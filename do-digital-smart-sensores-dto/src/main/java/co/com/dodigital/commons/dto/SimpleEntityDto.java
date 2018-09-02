package co.com.dodigital.commons.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.anexa.core.domain.ObjectAuditableByTime;
import com.anexa.core.domain.VersionableObject;
import com.anexa.core.dto.EntityDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public abstract class SimpleEntityDto<ID> extends EntityDto<ID> implements VersionableObject, ObjectAuditableByTime {

	@NumberFormat
	private int version;

	@DateTimeFormat(style = "M-")
	private LocalDateTime fechaCreacion;

	@DateTimeFormat(style = "M-")
	private LocalDateTime fechaModificacion;

	public SimpleEntityDto(ID id, int version, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {
		super(id);
		this.version = version;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
	}
}
