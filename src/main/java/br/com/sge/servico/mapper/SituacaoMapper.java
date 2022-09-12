package br.com.sge.servico.mapper;

import br.com.sge.dominio.Situacao;
import br.com.sge.servico.DTO.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface SituacaoMapper extends EntityMapper<SelectDTO, Situacao> {

    @Mapping(source = "id", target = "value")
    @Mapping(source = "descricao", target = "label")
    SelectDTO toDTO(Situacao situacao);

    @InheritInverseConfiguration
    Situacao toEntity(SelectDTO dto);
}
