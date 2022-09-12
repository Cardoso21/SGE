package br.com.sge.web.rest;

import br.com.sge.servico.DTO.SelectDTO;
import br.com.sge.servico.PagamentoServico;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin()
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/cargos")
public class PagamentoRecurso {

    private final PagamentoServico pagamentoServico;

    @GetMapping
    public ResponseEntity<List<SelectDTO>> buscarTodos(){
        return ResponseEntity.ok(pagamentoServico.listarTodos());
    }

}
