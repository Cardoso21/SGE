package br.com.sge.servico;

import br.com.sge.repositorio.PagamentoRepositorio;
import br.com.sge.servico.DTO.SelectDTO;
import br.com.sge.servico.mapper.PagamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PagamentoServico {

    private final PagamentoMapper pagamentoMapper;

    private final PagamentoRepositorio pagamentoRepositorio;

    public List<SelectDTO> listarTodos(){
        return pagamentoMapper.toDTO(pagamentoRepositorio.findAll());
    }
}
