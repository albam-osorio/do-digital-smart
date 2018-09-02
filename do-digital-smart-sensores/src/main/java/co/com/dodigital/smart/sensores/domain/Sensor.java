package co.com.dodigital.smart.sensores.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import co.com.dodigital.commons.domain.BusinessEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sensores")
@DynamicUpdate
@AttributeOverride(name = "id", column = @Column(name = "id_sensor"))
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Sensor extends BusinessEntity<Long> {

	@Column(name = "id_monitor")
	@NotNull
	private long idMonitor;

	@Column(name = "codigo", length = 50, nullable = false)
	@NotNull
	@Size(max = 50)
	private String codigo;

	@Column(name = "id_puesto")
	private Long idPuesto;

	@Column(name = "activo", nullable = false)
	private boolean activo;

}
