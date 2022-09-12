package br.com.sge.servico;

import br.com.sge.dominio.Usuario;
import br.com.sge.repositorio.UsuarioRepositorio;
import br.com.sge.servico.DTO.SelectDTO;
import br.com.sge.servico.DTO.UsuarioDTO;
import br.com.sge.servico.excecao.ObjectnotFoundException;
import br.com.sge.servico.filtro.UsuarioFiltro;
import br.com.sge.servico.mapper.UsuarioMapper;
import br.com.sge.servico.mapper.UsuarioSelectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class UsuarioServico implements Serializable {

    private final UsuarioRepositorio usuarioRepositorio;
    private final UsuarioMapper usuarioMapper;
    private final EventoServico eventoServico;
    private final UsuarioSelectMapper usuarioSelectMapper;

    public UsuarioDTO encontrarPorId(Long id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(ObjectnotFoundException::new);
        return usuarioMapper.toDTO(usuario);
    }

    public List<UsuarioDTO> buscarTodos(){
        return usuarioMapper.toDTO(usuarioRepositorio.findAll());
    }

    public List<SelectDTO> buscarTodosSelect(){
        return usuarioSelectMapper.toDTO(usuarioRepositorio.findAll());
    }


    public boolean validaEmail(UsuarioDTO usuarioDTO) throws ObjectnotFoundException {
        if (!usuarioRepositorio.existsByEmail(usuarioDTO.getEmail())){
            return true;
        }
        throw new ObjectnotFoundException("Email já cadastrado no banco "+ usuarioDTO.getEmail());

    }
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) throws ObjectnotFoundException {
        if (validaEmail(usuarioDTO)){
            Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
            usuario.setStatus(true);
            Usuario usuarioSalva = usuarioRepositorio.save(usuario);
            return usuarioMapper.toDTO(usuarioSalva);
        }
        throw new ObjectnotFoundException(" " + usuarioDTO.getEmail());
    }

    public UsuarioDTO editar(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario usuarioAtualiza = usuarioRepositorio.save(usuario);
        return usuarioMapper.toDTO(usuarioAtualiza);
    }

    public void ativarUsuario(Long id){
        UsuarioDTO usuarioDTO = encontrarPorId(id);
        usuarioDTO.setStatus(true);
        editar(usuarioDTO);
    }

    public void inativarUsuario(Long id){
        UsuarioDTO usuarioDTO = encontrarPorId(id);
        eventoServico.analisaUsuario(usuarioMapper.toEntity(usuarioDTO));
        if (usuarioDTO.isStatus()){
            usuarioDTO.setStatus(false);
        } else {
            usuarioDTO.setStatus(true);
        }
        editar(usuarioDTO);
    }

    public List<UsuarioDTO> buscarTodosFiltro(UsuarioFiltro usuarioFiltro) {
        return usuarioMapper.toDTO(usuarioRepositorio.findAll(usuarioFiltro.filter()));
    }

}