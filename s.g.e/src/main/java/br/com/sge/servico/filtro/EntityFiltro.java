package br.com.sge.servico.filtro;

import org.springframework.data.jpa.domain.Specification;

public interface EntityFiltro <T>{

    Specification<T> filter();
}
