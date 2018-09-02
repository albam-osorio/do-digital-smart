package co.com.dodigital.smart.sensores.repository;

import java.util.Optional;

import com.anexa.core.data.jpa.repository.IdentifiedDomainObjectRepository;

import co.com.dodigital.smart.sensores.domain.Puesto;

public interface PuestoRepository extends IdentifiedDomainObjectRepository<Puesto, Long> {

	Optional<Puesto> findByIdZonaAndCodigo(long idZona, String codigo);

}