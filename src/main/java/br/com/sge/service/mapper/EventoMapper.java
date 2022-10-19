package br.com.sge.service.mapper;

import br.com.sge.dominio.Evento;
import br.com.sge.service.dto.EventoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MotivoSelectmapper.class,SituacaoSelectMapper.class, UsuarioSelectMapper.class})
public interface EventoMapper extends EntityMapper<EventoDTO, Evento> {

}
