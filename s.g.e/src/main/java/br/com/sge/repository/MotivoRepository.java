package br.com.sge.repository;


import br.com.sge.dominio.Motivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotivoRepository extends JpaRepository<Motivo, Long> {

}
