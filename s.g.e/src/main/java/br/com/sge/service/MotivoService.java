package br.com.sge.service;


import br.com.sge.dominio.Motivo;
import br.com.sge.repository.MotivoRepository;
import br.com.sge.service.dto.MotivoDTO;
import br.com.sge.service.dto.SelectDTO;
import br.com.sge.service.exception.RegraNegocioException;
import br.com.sge.service.mapper.MotivoMapper;
import br.com.sge.service.mapper.MotivoSelectmapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class MotivoService {

   private final MotivoRepository motivoRepository;
   private final EventoService eventoService;
   private final MotivoMapper motivoMapper;
   private final MotivoSelectmapper motivoSelectmapper;

    public List<MotivoDTO> exibirTodosMotivos(){
        return motivoMapper.toDto(motivoRepository.findAll());
    }
   public MotivoDTO exibirMotivoPorId(Long id){
       Motivo motivo = motivoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Motivo não existe"));
       return motivoMapper.toDto(motivo);
   }

    public List<SelectDTO> exibirMotivosEmSelect(){
       return motivoSelectmapper.toDto(motivoRepository.findAll());
    }
   public MotivoDTO salvarMotivo(MotivoDTO motivoDTO){
       Motivo motivo = motivoMapper.toEntity(motivoDTO);
       Motivo motivoSalvar = motivoRepository.save(motivo);
       return motivoMapper.toDto(motivoSalvar);
   }

   public void deletarMotivo(Long id){
       Motivo motivo  = motivoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Motivo não existe"));
    if(eventoService.buscarMotivosEmEventos(motivo).isPresent()){
       throw new RegraNegocioException("Motivo não pode ser excluido por estar vinculado a um evento");
       }
       motivoRepository.deleteById(id);

   }
}
