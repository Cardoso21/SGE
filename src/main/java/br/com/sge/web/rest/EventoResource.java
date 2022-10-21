package br.com.sge.web.rest;

import br.com.sge.service.EventoService;
import br.com.sge.service.dto.EventoDTO;
import br.com.sge.service.dto.EventoListarDTO;
import br.com.sge.service.filter.EventoFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/evento")
@RequiredArgsConstructor
public class EventoResource {
    private final EventoService eventoService;


    @GetMapping("/filtro")
    public ResponseEntity<List<EventoListarDTO>> filtrarEventos(EventoFilter evento){
        return ResponseEntity.ok(eventoService.filtrarEventos(evento));
    }

    @GetMapping("{id}")
    public ResponseEntity<EventoDTO> exibirEventoPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(eventoService.mostrarEventoPorId(id));
    }

    @PostMapping
    public ResponseEntity<EventoDTO> salvarEvento(@Valid @RequestBody EventoDTO eventoDTO) {
        EventoDTO eventoSalvo = eventoService.salvarEvento(eventoDTO);
        return ResponseEntity.created(URI.create("api/evento/filtro?id="+eventoSalvo.getId())).body(eventoDTO);
    }

    @PutMapping
    public ResponseEntity<EventoDTO> editarEvento(@Valid @RequestBody EventoDTO eventoDTO) {
        return ResponseEntity.ok(eventoService.editarEvento(eventoDTO));
    }
    @PutMapping("/adiar/{id}")
    public ResponseEntity<Void> adiarEvento(@PathVariable("id") Long id){
        eventoService.adiarEvento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/trocar/{idPri}/{idSec}")
    public ResponseEntity<Void> trocarDataDeEventos(@PathVariable("idPri")Long idPri,@PathVariable("idSec") Long idSec) {
        eventoService.trocarEventosDeData(idPri, idSec);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> cancelarEvento(@PathVariable("id") Long id) {
        eventoService.cancelarEvento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
