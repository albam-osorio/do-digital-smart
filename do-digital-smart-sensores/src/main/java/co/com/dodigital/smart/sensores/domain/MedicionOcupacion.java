package co.com.dodigital.smart.sensores.domain;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import co.com.dodigital.commons.domain.SimpleEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "mediciones_ocupacion")
@AttributeOverride(name = "id", column = @Column(name = "id_medicion_ocupacion"))
@DynamicUpdate
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class MedicionOcupacion extends SimpleEntity<Long> {

	@Column(name = "id_sensor")
	@NotNull
	private long idSensor;

	@Column(name = "id_puesto")
	@NotNull
	private long idPuesto;

	@Column(name = "id_persona")
	private Long idPersona;

	@Column(name = "fecha_medicion", nullable = false)
	@NotNull
	private LocalDateTime fechaMedicion;

	@Column(name = "cantidad_personas", nullable = false)
	private int cantidadPersonas;

	@Column(name = "actividad", nullable = false)
	private int actividad;

	@Column(name = "inactividad", nullable = false)
	private int inactividad;
}