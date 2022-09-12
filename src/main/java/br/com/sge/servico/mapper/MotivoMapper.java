package br.com.sge.servico.mapper;

import br.com.sge.dominio.Motivo;
import br.com.sge.servico.DTO.MotivoDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface MotivoMapper extends EntityMapper<MotivoDTO, Motivo>{

}
