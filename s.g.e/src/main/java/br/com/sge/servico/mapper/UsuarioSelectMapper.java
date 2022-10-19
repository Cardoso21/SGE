package br.com.sge.servico.mapper;

import br.com.sge.dominio.Usuario;
import br.com.sge.servico.DTO.SelectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface UsuarioSelectMapper extends EntityMapper<SelectDTO, Usuario> {

    @Mapping(source= "id", target = "value")
    @Mapping(source = "nome", target="label")
    SelectDTO toDTO(Usuario usuario);

    @InheritInverseConfiguration
    Usuario toEntity(SelectDTO select);
}
