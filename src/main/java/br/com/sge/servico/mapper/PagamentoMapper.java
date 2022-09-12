package br.com.sge.servico.mapper;

import br.com.sge.dominio.Pagamento;
import br.com.sge.servico.DTO.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface PagamentoMapper extends EntityMapper<SelectDTO, Pagamento> {

    @Mapping(source = "id", target = "value")
    @Mapping(source = "descricao", target = "label")
    SelectDTO toDTO(Pagamento pagamento);

    @InheritInverseConfiguration
    Pagamento toEntity(SelectDTO dto);
}
