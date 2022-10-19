package br.com.sge.repositorio;

import br.com.sge.dominio.Motivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MotivoRepositorio extends JpaRepository<Motivo, Long>, JpaSpecificationExecutor<Motivo> {

}
