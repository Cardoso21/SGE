package basis.bsb.EMS.servico.Mapper;

import basis.bsb.EMS.dominio.Evento;
import basis.bsb.EMS.servico.DTO.EventoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SituacaoMapper.class, MotivoSelectMapper.class, UsuarioSelectMapper.class})
public interface EventoMapper extends EntityMapper<EventoDTO, Evento> {

}
