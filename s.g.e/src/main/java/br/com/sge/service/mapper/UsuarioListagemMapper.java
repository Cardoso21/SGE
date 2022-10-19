package br.com.sge.service.mapper;

import br.com.sge.dominio.Usuario;
import br.com.sge.service.dto.UsuarioListagemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CargoSelectMapper.class})
public interface UsuarioListagemMapper extends EntityMapper<UsuarioListagemDTO, Usuario> {


}
