package br.com.sge.service.mapper;

import br.com.sge.dominio.Motivo;
import br.com.sge.service.dto.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {})
public interface MotivoSelectmapper extends EntityMapper<SelectDTO, Motivo> {

    @Mapping(source = "id", target = "value")
    @Mapping(source = "motivo", target = "label")
    SelectDTO toDto(Motivo motivo);

    @InheritInverseConfiguration
    Motivo toEntity(SelectDTO selectDTO);
}
