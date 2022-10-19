package br.com.sge.repositorio;

import br.com.sge.dominio.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepositorio extends JpaRepository<Pagamento,Long> {
}
