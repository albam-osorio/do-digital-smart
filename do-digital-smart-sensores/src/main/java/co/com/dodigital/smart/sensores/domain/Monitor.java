package co.com.dodigital.smart.sensores.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import com.anexa.core.domain.ObjectWithCode;

import co.com.dodigital.commons.domain.BusinessEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "monitores")
@DynamicUpdate
@AttributeOverride(name = "id", column = @Column(name = "id_monitor"))
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Monitor extends BusinessEntity<Long> implements ObjectWithCode<Long> {

	@Column(name = "codigo", length = 50, nullable = false)
	@NotNull
	@Size(max = 50)
	private String codigo;
}
