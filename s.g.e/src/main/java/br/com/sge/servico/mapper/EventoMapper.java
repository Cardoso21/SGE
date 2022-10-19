package br.com.sge.servico.mapper;

import br.com.sge.dominio.Evento;
import br.com.sge.servico.DTO.EventoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SituacaoMapper.class, MotivoSelectMapper.class, UsuarioSelectMapper.class})
public interface EventoMapper extends EntityMapper<EventoDTO, Evento> {

}
