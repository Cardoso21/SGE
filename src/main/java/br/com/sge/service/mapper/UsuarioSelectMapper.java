package br.com.sge.service.mapper;

import br.com.sge.dominio.Usuario;
import br.com.sge.service.dto.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface UsuarioSelectMapper extends EntityMapper<SelectDTO, Usuario>{



    @Mapping(source = "id", target = "value")
    @Mapping(source = "nome", target = "label")
    SelectDTO toDto(Usuario Usuario);


    @InheritInverseConfiguration
    Usuario toEntity(SelectDTO selectDTO);

}
