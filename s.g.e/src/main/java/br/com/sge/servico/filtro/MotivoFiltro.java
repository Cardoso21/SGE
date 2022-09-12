package br.com.sge.servico.filtro;

import br.com.sge.dominio.Motivo;
import br.com.sge.dominio.Motivo_;
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
public class MotivoFiltro implements EntityFiltro<Motivo> {

    private Long id;
    private String titulo;
    private String descricao;

    @Override
    public Specification<Motivo> filter(){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.and(getPredicates(root, query, criteriaBuilder).toArray(new Predicate[0])));
    }
    private List<Predicate> getPredicates(Root<Motivo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(Motivo_.id)));


        if (titulo != null) {
            predicates.add(criteriaBuilder.like(root.get(Motivo_.titulo), "%" + titulo + "%"));
        }

        if (descricao != null){
            predicates.add(criteriaBuilder.like(root.get(Motivo_.descricao), "%" + descricao + "%"));
        }

        if (id != null){
            predicates.add(criteriaBuilder.equal(root.get(Motivo_.id),id));
        }
        return predicates;
    }
}

