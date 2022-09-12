package br.com.sge.servico;

import br.com.sge.dominio.Evento;
import br.com.sge.dominio.Usuario;
import br.com.sge.repositorio.EventoRepositorio;
import br.com.sge.servico.DTO.EmailDTO;
import br.com.sge.servico.DTO.EventoDTO;
import br.com.sge.servico.DTO.ListaEventoDTO;
import br.com.sge.servico.excecao.ObjectnotFoundException;
import br.com.sge.servico.filtro.EventoFiltro;
import br.com.sge.servico.mapper.EventoMapper;
import br.com.sge.servico.mapper.ListaEventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class EventoServico implements Serializable {

    private final EventoRepositorio eventoRepositorio;
    private final EventoMapper eventoMapper;
    private final EmailServico emailServico;
    private final ListaEventoMapper listaEventoMapper;


    public ListaEventoDTO encontrarPorId(Long id) {
        Evento evento = eventoRepositorio.findById(id).orElseThrow(() -> new ObjectnotFoundException("Evento nãp encontrado!" + id));
        return listaEventoMapper.toDTO(evento);
    }

    public List<ListaEventoDTO> encontrarTodosOrdenado() {
        return listaEventoMapper.toDTO(eventoRepositorio.OrderByDate());
    }

    public boolean validaEvento(EventoDTO eventoDTO) {
        if (!eventoRepositorio.existsByDataEvento(eventoDTO.getDataEvento())) {
            return true;
        }
        throw new ObjectnotFoundException("Dois eventos não podem ser cadastrados no mesmo dia" + eventoDTO.getDataEvento());

    }

    public EventoDTO salvar(EventoDTO eventoDTO) {
        if (validaEvento(eventoDTO)) {
            Evento evento = eventoMapper.toEntity(eventoDTO);
            Evento eventoSalva = eventoRepositorio.save(evento);
            return eventoMapper.toDTO(eventoSalva);
        }
        throw new ObjectnotFoundException("Não pode salvar Evento" + eventoDTO.getDataEvento());

    }

    public EventoDTO editar(EventoDTO eventoDTO) {
        Evento evento = eventoMapper.toEntity(eventoDTO);
        Evento eventoAtualiza = eventoRepositorio.save(evento);
        return eventoMapper.toDTO(eventoAtualiza);
    }


    @Scheduled(cron = "29 34  10 * * ?")
    public void rotinaDeEmail() {
        Optional<Evento> eventoOptional = eventoRepositorio.findTodayEvento(LocalDate.now());
        if (eventoOptional.isPresent()) {
            List<String> copias = new ArrayList<>();
            EmailDTO emailDTO = new EmailDTO();
            Evento eventoDoDia = eventoOptional.get();
            emailDTO.setDestinatario("projeto.formacaobsb@gmail.com");
            emailDTO.setAssunto("Hoje tem um Patrocinador ira pargar o lache!!!");
            emailDTO.setCorpo("Esta chegando a hora do evento!!!!" + eventoDoDia.getMotivo().getTitulo() + "Esse evento sera patrocinado por" +
                    eventoDoDia.getUsuario().toArray()[0]+ "e por mais outras" + (eventoDoDia.getUsuario().toArray().length -1)+ "pessoas" );

            for(Usuario user :eventoDoDia.getUsuario()) {
                copias.add(user.getEmail());
            }
            emailDTO.setCopias(copias);
            System.out.println(emailDTO.getCopias());
            emailServico.sendEmail(emailDTO);

        }
    }

    public boolean verificaMotivoDentroEvento(Long id){
        if(!eventoRepositorio.existsByMotivo(id)){
            return false;
        }
        return true;
    }

    public List<EventoDTO> trocaDataEvento(Long id1, Long id2) {
        Evento evento1 = eventoRepositorio.findById(id1).orElseThrow(() -> new ObjectnotFoundException(""));
        Evento evento2 = eventoRepositorio.findById(id2).orElseThrow(() -> new ObjectnotFoundException(""));

        if (!evento1.getSituacao().equals(2) || !evento1.getSituacao().equals(3) && !evento2.getSituacao().equals(2)
                || !evento2.getSituacao().equals(3)) {
            LocalDate data1 = evento1.getDataEvento();
            LocalDate data2 = evento2.getDataEvento();

            evento1.setDataEvento(data2);
            evento2.setDataEvento(data1);

            eventoRepositorio.save(evento1);
            eventoRepositorio.save(evento2);

            return eventoMapper.toDTO(eventoRepositorio.findAll());
        }
        throw new ObjectnotFoundException("Não pode realizar a troca de Datas entre eventos" + evento1.getDataEvento() + evento2.getDataEvento());

    }

    public List<EventoDTO> adiaEvento(Long id) {
        Evento evento = eventoRepositorio.findById(id).orElseThrow(() -> new ObjectnotFoundException(""));
        LocalDate dataEvento = evento.getDataEvento();
        for (Evento l : eventoRepositorio.OrderByDateAdiamento(dataEvento)) {
            l.setDataEvento(l.getDataEvento().plusWeeks(1));
            eventoRepositorio.save(l);
        }
        return eventoMapper.toDTO(eventoRepositorio.OrderByDate());
    }

    public List<EventoDTO> buscarTodosFiltro(EventoFiltro eventoFiltro) {
        return eventoMapper.toDTO(eventoRepositorio.findAll(eventoFiltro.filter()));
    }

    public void excluirEvento(Long id){
        eventoRepositorio.deleteById(id);
    }

    public void analisaUsuario(Usuario usuario){
        List<Evento> lista = eventoRepositorio.getAllByUsuario(usuario);
        List<Usuario> listaUsuario = new ArrayList<>();
        for (Evento e: lista) {
            listaUsuario = e.getUsuario();
            if (listaUsuario.toArray().length == 1){
                eventoRepositorio.delete(e);
            } else {
                listaUsuario.remove(usuario);
                e.setUsuario(listaUsuario);
                eventoRepositorio.save(e);
            }
        }
    }

}
