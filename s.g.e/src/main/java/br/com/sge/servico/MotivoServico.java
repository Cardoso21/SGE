package br.com.sge.servico;

import br.com.sge.dominio.Motivo;
import br.com.sge.repositorio.MotivoRepositorio;
import br.com.sge.servico.DTO.MotivoDTO;
import br.com.sge.servico.DTO.SelectDTO;
import br.com.sge.servico.excecao.NaoPodeExcluirException;
import br.com.sge.servico.filtro.MotivoFiltro;
import br.com.sge.servico.mapper.MotivoMapper;
import br.com.sge.servico.mapper.MotivoSelectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MotivoServico implements Serializable {

    private final MotivoMapper motivoMapper;
    private final MotivoSelectMapper motivoSelectMapper;
    private final MotivoRepositorio motivoRepositorio;
    private final EventoServico eventoServico;


    public List<SelectDTO> ListaTodosMotivosSelect(){
        return motivoSelectMapper.toDTO(motivoRepositorio.findAll());
    }

    public List<MotivoDTO> ListaTodosMotivos(){
        return motivoMapper.toDTO(motivoRepositorio.findAll());
    }

    public MotivoDTO encontararPorId(Long id) throws ObjectnotFoundException {
        Motivo motivo = motivoRepositorio.findById(id).orElseThrow(ObjectnotFoundException ::new);
        return motivoMapper.toDTO(motivo);
    }

    public MotivoDTO salvarMotivo(MotivoDTO motivoDTO){
        Motivo motivo = motivoMapper.toEntity(motivoDTO);
        Motivo motivoSalva = motivoRepositorio.save(motivo);
        return motivoMapper.toDTO(motivoSalva);
    }

    public MotivoDTO editarMotivo(MotivoDTO motivoDTO){
        Motivo motivo = motivoMapper.toEntity(motivoDTO);
        Motivo motivoSalva = motivoRepositorio.save(motivo);
        return motivoMapper.toDTO(motivoSalva);
    }

    public void deletarMotivo(Long id){
        try {
            if(!eventoServico.verificaMotivoDentroEvento(id)){
                motivoRepositorio.deleteById(id);
            }else {

            }

        }catch (DataIntegrityViolationException e){
            throw new NaoPodeExcluirException("Não pode excluir um motivo que esteja relacionado ao evento!");
        }

    }

    public List<MotivoDTO> buscarTodosFiltro(MotivoFiltro filtro){
        return motivoMapper.toDTO(motivoRepositorio.findAll(filtro.filter()));
    }
}
