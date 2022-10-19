package br.com.sge.service.mapper;

import br.com.sge.dominio.Motivo;
import br.com.sge.service.dto.MotivoDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface MotivoMapper extends EntityMapper<MotivoDTO, Motivo> {
}
