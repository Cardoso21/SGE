package br.com.sge.servico.mapper;

import br.com.sge.dominio.Motivo;
import br.com.sge.servico.DTO.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface MotivoSelectMapper extends EntityMapper<SelectDTO, Motivo> {

    @Mapping(source= "id", target = "value")
    @Mapping(source = "titulo", target="label")
    SelectDTO toDTO(Motivo motivo);

    @InheritInverseConfiguration
    Motivo toEntity(SelectDTO dto);
}
