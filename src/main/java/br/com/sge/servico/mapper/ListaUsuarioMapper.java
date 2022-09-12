package br.com.sge.servico.mapper;

import br.com.sge.dominio.Usuario;
import br.com.sge.servico.DTO.ListaUsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PagamentoMapper.class})
public interface ListaUsuarioMapper extends EntityMapper<ListaUsuarioDTO, Usuario>{
}
