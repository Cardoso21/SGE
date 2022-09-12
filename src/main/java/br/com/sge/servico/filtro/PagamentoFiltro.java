package br.com.sge.servico.filtro;

import br.com.sge.dominio.Pagamento;
import br.com.sge.dominio.Pagamento_;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class PagamentoFiltro implements EntityFiltro<Pagamento> {

    private Long id;
    private String descricao;

    @Override
    public Specification<Pagamento> filter(){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.and(getPredicates(root, query, criteriaBuilder)
                .toArray(new Predicate[0])));
    }
    private List<Predicate> getPredicates(Root<Pagamento> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Pagamento_.id)));

        if (descricao != null){
            predicates.add(criteriaBuilder.like(root.get(Pagamento_.descricao),
                "%" + descricao + "%"));
        }

        if (id != null){
            predicates.add(criteriaBuilder.equal(root.get(Pagamento_.id),id));
        }
        return predicates;
    }
}
