package br.com.sge.servico.mapper;

import br.com.sge.dominio.Evento;
import br.com.sge.servico.DTO.ListaEventoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SituacaoMapper.class, MotivoMapper.class, UsuarioMapper.class})
public interface ListaEventoMapper extends EntityMapper<ListaEventoDTO, Evento>{
}
