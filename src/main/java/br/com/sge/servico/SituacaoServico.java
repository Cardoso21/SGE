package br.com.sge.servico;

import br.com.sge.repositorio.SituacaoRepositorio;
import br.com.sge.servico.DTO.SelectDTO;
import br.com.sge.servico.mapper.SituacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SituacaoServico {

    private final SituacaoMapper situacaoMapper;
    private final SituacaoRepositorio situacaoRepositorio;

    public List<SelectDTO> buscarTodos(){
        return situacaoMapper.toDTO(situacaoRepositorio.findAll());
    }
}
