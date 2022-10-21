package br.com.sge.web.rest;


import br.com.sge.service.UsuarioService;
import br.com.sge.service.dto.SelectDTO;
import br.com.sge.service.dto.UsuarioDTO;
import br.com.sge.service.dto.UsuarioListagemDTO;
import br.com.sge.service.filter.UsuarioFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<SelectDTO>> listarUsuariosEmSelect(){
        return ResponseEntity.ok(usuarioService.listarUsuariosEmSelect());
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<UsuarioListagemDTO>> exibirUsuariosFiltrado(UsuarioFilter usuario){
        return ResponseEntity.ok(usuarioService.mostrarTodosUsuariosFiltrado(usuario));
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> exibirUsuarioPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(usuarioService.mostrarUsuarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO salvo = usuarioService.salvarUsuario(usuarioDTO);
        return ResponseEntity.created(URI.create("api/usuario/filtro?id="+salvo.getId())).body(salvo);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.editarUsuario(usuarioDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioDTO> ativarUsuario(@Valid @PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.ativarusuario(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarUsuario(@Valid @PathVariable("id") Long id) {
        usuarioService.inativarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

