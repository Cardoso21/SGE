package br.com.sge.service.mapper;

import br.com.sge.dominio.Usuario;
import br.com.sge.service.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CargoSelectMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {

}
