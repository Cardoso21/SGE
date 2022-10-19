package br.com.sge.service.mapper;

import br.com.sge.dominio.Evento;
import br.com.sge.service.dto.EventoListarDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SituacaoSelectMapper.class})
public interface EventoListarMapper extends EntityMapper<EventoListarDTO, Evento> {
}
