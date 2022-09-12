package br.com.sge.web.rest;

import br.com.sge.servico.DTO.MotivoDTO;
import br.com.sge.servico.DTO.SelectDTO;
import br.com.sge.servico.MotivoServico;
import br.com.sge.servico.ObjectnotFoundException;
import br.com.sge.servico.filtro.MotivoFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/motivos")
public class MotivoRecurso {

    private final MotivoServico motivoServico;

    @PostMapping
    public ResponseEntity<MotivoDTO> inserir(@RequestBody MotivoDTO motivoDTO){
        return ResponseEntity.ok(motivoServico.salvarMotivo(motivoDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MotivoDTO> editar(@RequestBody MotivoDTO motivoDTO, @PathVariable Long id){
        motivoDTO.setId(id);
        return ResponseEntity.ok(motivoServico.editarMotivo(motivoDTO));
    }

    @GetMapping(value = "/select")
    public ResponseEntity<List<SelectDTO>> listarTodosSelect(){
        return ResponseEntity.ok(motivoServico.ListaTodosMotivosSelect());
    }

    @GetMapping
    public ResponseEntity<List<MotivoDTO>> listarTodos(){
        return ResponseEntity.ok(motivoServico.ListaTodosMotivos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MotivoDTO> listarPorId(@PathVariable Long id) throws ObjectnotFoundException {
        return ResponseEntity.ok(motivoServico.encontararPorId(id));
    }

    @GetMapping(value ="filtro")
    public ResponseEntity<List<MotivoDTO>> buscarTodosFiltro(MotivoFiltro filtro){
        return ResponseEntity.ok(motivoServico.buscarTodosFiltro(filtro));
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> deletarMotivo(@PathVariable Long id){
        motivoServico.deletarMotivo(id);
        return ResponseEntity.noContent().build();
    }


}



