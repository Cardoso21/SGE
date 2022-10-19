package br.com.sge.repositorio;

import br.com.sge.dominio.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoRepositorio extends JpaRepository<Situacao,Long> {
}
